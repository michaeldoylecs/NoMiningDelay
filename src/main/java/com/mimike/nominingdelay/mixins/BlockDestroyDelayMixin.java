package com.mimike.nominingdelay.mixins;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MultiPlayerGameMode.class)
public abstract class BlockDestroyDelayMixin
{
	@ModifyConstant(method = "startDestroyBlock", constant = @Constant(intValue = 5))
	private int startBlockDestroyDelayChange(int value)
	{
		return 0;
	}
	
	@ModifyConstant(method = "continueDestroyBlock", constant = @Constant(intValue = 5))
	private int continueBlockDestroyDelayChange(int value)
	{
		return 0;
	}
}
