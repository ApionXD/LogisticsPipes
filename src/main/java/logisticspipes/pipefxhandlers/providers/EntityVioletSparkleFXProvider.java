package logisticspipes.pipefxhandlers.providers;

import logisticspipes.pipefxhandlers.GenericSparkleFactory;
import logisticspipes.pipefxhandlers.ParticleProvider;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityFX;

public class EntityVioletSparkleFXProvider implements ParticleProvider {

    float red = 0.51F;
    float green = 0.04F;
    float blue = 0.73F;

    @Override
    public EntityFX createGenericParticle(WorldClient world, double x, double y, double z, int amount) {

        return GenericSparkleFactory.getSparkleInstance(world, x, y, z, red, green, blue, amount);
    }
}
