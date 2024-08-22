package net.wisty.mccourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties superSteak = new FoodProperties.Builder().nutrition(10).saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 12000), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000), 1f).build();

}
