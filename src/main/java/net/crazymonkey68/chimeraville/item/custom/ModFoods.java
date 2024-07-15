package net.crazymonkey68.chimeraville.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_LION_MEAT =
            new FoodProperties.Builder()
                    .alwaysEat()
                    .meat()
                    .nutrition(5)
                    .saturationMod(0.2f)
                    .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 1000), 0.3f).build();

    public static final FoodProperties COOKED_LION_MEAT =
            new FoodProperties.Builder()
                    .alwaysEat()
                    .meat()
                    .nutrition(12)
                    .saturationMod(0.6f).build();
}
