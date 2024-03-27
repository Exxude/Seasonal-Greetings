package lol.exxude.seasonal_greetings.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.swing.text.AttributeSet;
import java.awt.*;
import java.util.List;

public class CottonCandyBlackItem extends Item {
    public CottonCandyBlackItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.seasonal_greetings.cotton_candy_black")
                .withStyle(Style.EMPTY.withColor(TextColor.parseColor("#A0A0A0"))));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
