package lol.exxude.seasonal_greetings.item;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties EASTER_CHOCOLATE_EGG = new FoodProperties.Builder().nutrition(3).saturationMod(0.5f).fast().build();
    public static final FoodProperties EASTER_CHOCOLATE_BUNNY = new FoodProperties.Builder().nutrition(4).saturationMod(0.2f).fast().build();
    public static final FoodProperties EASTER_COTTON_CANDY_RED = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_BLUE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_GREEN = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_YELLOW = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_ORANGE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_BLACK = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.BAD_OMEN, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_PURPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_BROWN = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_LIME = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_LIGHT_BLUE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_CYAN = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_WHITE = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_PINK = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_MAGENTA = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_LIGHT_GRAY = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_GRAY = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200), 1).build();
    public static final FoodProperties EASTER_COTTON_CANDY_GOLDEN = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).fast().alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200), 1)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1200), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200), 1)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200), 1).build();

}
