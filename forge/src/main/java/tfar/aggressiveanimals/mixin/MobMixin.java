package tfar.aggressiveanimals.mixin;

import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.aggressiveanimals.AggressiveAnimals;
import tfar.aggressiveanimals.AggressiveAnimalsForge;

@Mixin(Mob.class)
public class MobMixin {
    @Inject(method = "<init>",at = @At("RETURN"))
    private void init(CallbackInfo ci) {
        AggressiveAnimalsForge.onMobInit((Mob)(Object)this);
    }
}
