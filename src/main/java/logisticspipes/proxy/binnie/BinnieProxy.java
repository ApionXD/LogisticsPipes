package logisticspipes.proxy.binnie;

import binnie.core.machines.Machine;
import binnie.core.machines.TileEntityMachine;
import binnie.genetics.machine.analyser.AnalyserPackage;
import java.lang.reflect.Field;
import logisticspipes.proxy.interfaces.IBinnieProxy;
import lombok.SneakyThrows;
import net.minecraft.tileentity.TileEntity;

public class BinnieProxy implements IBinnieProxy {

    private Field machine = null;
    private Field machinePackage = null;

    @Override
    @SneakyThrows(Exception.class)
    public boolean isTileAnalyser(TileEntity tile) {
        if (tile instanceof TileEntityMachine) {
            if (machine == null) {
                machine = TileEntityMachine.class.getDeclaredField("machine");
                machine.setAccessible(true);
                machinePackage = Machine.class.getDeclaredField("machinePackage");
                machinePackage.setAccessible(true);
            }
            Object m = machine.get(tile);
            Object mP = machinePackage.get(m);
            if (mP instanceof AnalyserPackage) {
                return true;
            }
        }
        return false;
    }
}
