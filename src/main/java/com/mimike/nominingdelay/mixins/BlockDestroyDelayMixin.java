package com.mimike.nominingdelay.mixins;

import com.mimike.nominingdelay.config.NoMiningDelayServerConfig;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MultiPlayerGameMode.class)
public abstract class BlockDestroyDelayMixin
{
	@ModifyConstant(
		method = {
			"continueDestroyBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z",
			"startDestroyBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z"
		},
		constant = @Constant(intValue = 5, log = true),
		expect = 3
	)
	private int nominingdelay_blockDestroyDelayChange(int value)
	{
		return NoMiningDelayServerConfig.BLOCK_BREAK_DELAY.get();
	}
}
