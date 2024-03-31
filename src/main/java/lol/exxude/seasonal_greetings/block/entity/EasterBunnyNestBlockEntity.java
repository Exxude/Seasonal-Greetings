package lol.exxude.seasonal_greetings.block.entity;

import lol.exxude.seasonal_greetings.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class EasterBunnyNestBlockEntity extends BlockEntity {
    private Integer level;
    private Integer progress;
    private String color = "";
    private List<String> COLORS = List.of("RED", "BLUE", "GREEN", "YELLOW", "ORANGE", "BROWN", "LIME", "LIGHT_BLUE",
            "BLACK", "PURPLE", "CYAN", "WHITE", "PINK", "MAGENTA", "LIGHT_GRAY", "GRAY", "WILD", "GOLDEN");
    private static final List<RegistryObject<Block>> EASTER_EGG_BLOCKS = List.of(ModBlocks.EASTER_EGG_RED_BLOCK, ModBlocks.EASTER_EGG_BLUE_BLOCK,
            ModBlocks.EASTER_EGG_GREEN_BLOCK, ModBlocks.EASTER_EGG_YELLOW_BLOCK, ModBlocks.EASTER_EGG_ORANGE_BLOCK, ModBlocks.EASTER_EGG_BROWN_BLOCK,
            ModBlocks.EASTER_EGG_LIME_BLOCK, ModBlocks.EASTER_EGG_LIGHT_BLUE_BLOCK, ModBlocks.EASTER_EGG_BLACK_BLOCK, ModBlocks.EASTER_EGG_PURPLE_BLOCK,
            ModBlocks.EASTER_EGG_CYAN_BLOCK, ModBlocks.EASTER_EGG_WHITE_BLOCK, ModBlocks.EASTER_EGG_PINK_BLOCK, ModBlocks.EASTER_EGG_MAGENTA_BLOCK,
            ModBlocks.EASTER_EGG_LIGHT_GRAY_BLOCK, ModBlocks.EASTER_EGG_GRAY_BLOCK, ModBlocks.EASTER_EGG_WILD_BLOCK, ModBlocks.EASTER_EGG_GOLDEN_BLOCK);

    public ItemStack getRenderStack() {
        Integer index = COLORS.indexOf(this.color);
        ItemStack item = EASTER_EGG_BLOCKS.get(index).get().asItem().getDefaultInstance();
        return item;
    }

    public EasterBunnyNestBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.EASTER_BUNNY_NEST_BE.get(), pPos, pBlockState);
        this.level = 0;
        this.progress = 0;
        if(Objects.equals(this.color, "")) {
            Integer rColor = new Random().nextInt(COLORS.size());
            this.color = COLORS.get(rColor);
        }
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(this.level);
        for(int i = 0; i < this.level; i++) {
            inventory.setItem(i, getRenderStack());
            for(int r = 0; r < 2; r++) {
                Rabbit rabbit = new Rabbit(EntityType.RABBIT, this.getLevel());
                rabbit.setVariant(Rabbit.Variant.EVIL);
                rabbit.setPosRaw(this.worldPosition.above(1).getX(), this.worldPosition.above(1).getY(), this.worldPosition.above(1).getZ());
                this.getLevel().addFreshEntity(rabbit);
            }
        }
        this.level = 0;
        updateBlockState();
        Containers.dropContents(this.getLevel(), this.worldPosition, inventory);
    }

    public Integer getUpgradeLevel() {
        return this.level;
    }

    private void updateBlockState() {
        Level pLevel = this.getLevel();
        if(!pLevel.isClientSide()) {
            pLevel.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putInt("easter_bunny_nest.level", level);
        pTag.putInt("easter_bunny_nest.progress", progress);
        pTag.putString("easter_bunny_basket.color", color);
        super.saveAdditional(pTag);
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        level = pTag.getInt("easter_bunny_nest.level");
        progress = pTag.getInt("easter_bunny_nest.progress");
        color = pTag.getString("easter_bunny_basket.color");
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(progress < 500 && level < 4) { // 6000
            progress++;
        } else if(level < 4) {
            progress = 0;
            level++;
            updateBlockState();
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
