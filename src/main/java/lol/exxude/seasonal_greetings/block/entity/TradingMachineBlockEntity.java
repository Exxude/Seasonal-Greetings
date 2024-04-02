package lol.exxude.seasonal_greetings.block.entity;

import lol.exxude.seasonal_greetings.recipe.TradingMachineRecipe;
import lol.exxude.seasonal_greetings.screen.TradingMachineMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class TradingMachineBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemInputHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            saveAdditional(saveWithFullMetadata());
        }
    };
    private final ItemStackHandler itemOutputHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            saveAdditional(saveWithFullMetadata());
        }
    };

    public static final Property<Boolean> LIT = BlockStateProperties.LIT;

    private static final int INPUT_SLOT = 0;
    private static final int CATALYST_SLOT = 1;
    private static final int OUTPUT_SLOT = 0;

    private LazyOptional<IItemHandler> lazyItemInputHandler = LazyOptional.empty();
    private LazyOptional<IItemHandler> lazyItemOutputHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 500;

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(side == Direction.DOWN && cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemOutputHandler.cast();
        } else if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemInputHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemInputHandler = LazyOptional.of(() -> itemInputHandler);
        lazyItemOutputHandler = LazyOptional.of(() -> itemOutputHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemInputHandler.invalidate();
        lazyItemOutputHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemInputHandler.getSlots() + itemOutputHandler.getSlots());
        for(int i = 0; i < itemInputHandler.getSlots(); i++) {
            inventory.addItem(itemInputHandler.getStackInSlot(i));
        }
        for(int i = 0; i < itemOutputHandler.getSlots(); i++) {
            inventory.addItem(itemOutputHandler.getStackInSlot(i));
        }


        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public TradingMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.TRADING_MACHINE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> TradingMachineBlockEntity.this.progress;
                    case 1 -> TradingMachineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> TradingMachineBlockEntity.this.progress = pValue;
                    case 1 -> TradingMachineBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.seasonal_greetings.trading_machine");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new TradingMachineMenu(i, inventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inputInventory", itemInputHandler.serializeNBT());
        pTag.put("outputInventory", itemOutputHandler.serializeNBT());
        pTag.putInt("trading_machine.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemInputHandler.deserializeNBT(pTag.getCompound("inputInventory"));
        itemOutputHandler.deserializeNBT(pTag.getCompound("outputInventory"));
        progress = pTag.getInt("trading_machine.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);
            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        updateBlockState(false);
        progress = 0;
    }

    private void craftItem() {
        List<TradingMachineRecipe> recipes = getCurrentRecipe();
        List<TradingMachineRecipe> weightedRecipes = new ArrayList<>();
        for(int i = 0; i < recipes.size(); i++) {
            for(int w = 0; w < recipes.get(i).getWeight(); w++) {
                weightedRecipes.add(recipes.get(i));
            }
        }
        Integer number = new Random().nextInt(weightedRecipes.size() + 1) + 1;
        TradingMachineRecipe recipe = weightedRecipes.get(number);
        ItemStack result = recipe.getResultItem(getLevel().registryAccess());

        this.itemInputHandler.extractItem(INPUT_SLOT, 1, false);
        this.itemInputHandler.extractItem(CATALYST_SLOT, 1, false);

        this.itemOutputHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                this.itemOutputHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
        updateBlockState(false);
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        updateBlockState(true);
        progress++;
    }

    private boolean hasRecipe() {
        List<TradingMachineRecipe> recipes = getCurrentRecipe();
        //System.out.println(recipes);

        if(recipes.isEmpty()) {
            return false;
        }
        return outputIsEmpty();
    }

    private boolean outputIsEmpty() {
        return this.itemOutputHandler.getStackInSlot(OUTPUT_SLOT).isEmpty();
    }

    private List<TradingMachineRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemInputHandler.getSlots());
        for(int i = 0; i < itemInputHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemInputHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipesFor(TradingMachineRecipe.Type.INSTANCE, inventory, level);
    }

    private void updateBlockState(Boolean lit) {
        BlockState updatedState = this.getBlockState().setValue(LIT, lit);
        assert this.level != null;
        this.level.setBlockAndUpdate(this.getBlockPos(), updatedState);
    }
}
