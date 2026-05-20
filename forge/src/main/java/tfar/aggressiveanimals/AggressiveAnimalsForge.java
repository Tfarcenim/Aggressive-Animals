package tfar.aggressiveanimals;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class AggressiveAnimalsForge {
    
    public AggressiveAnimalsForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        AggressiveAnimals.init();
        
    }

    public static void onMobInit(Mob mob) {
        if (mob.level()!= null && !mob.level().isClientSide) {
            if (mob instanceof Fox || mob instanceof Wolf) {
                mob.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(mob, Player.class, true));
                mob.goalSelector.removeAllGoals(goal -> {
                   return goal instanceof AvoidEntityGoal<?> avoidEntityGoal && avoidEntityGoal.avoidClass == Player.class;
                });
            }
        }
    }
}