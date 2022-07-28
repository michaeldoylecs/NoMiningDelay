package com.mimike.nominingdelay.mixins;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class BlockDestroyDelayMixin
{
	@Shadow
	private int destroyDelay;
	
	@Shadow
	private GameType localPlayerMode;
	
	@Inject(
		method = "continueDestroyBlock",
		at = @At("HEAD")
	)
	public void onContinueDestroyBlock(
		BlockPos pPosBlock,
		Direction pDirectionFacing,
		CallbackInfoReturnable<Boolean> cir)
	{
		if (localPlayerMode.isSurvival())
		{
			destroyDelay = 0;
		}
	}
}
