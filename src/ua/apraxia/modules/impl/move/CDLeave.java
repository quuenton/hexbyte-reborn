package ua.apraxia.modules.impl.move;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import ua.apraxia.eventapi.EventTarget;
import ua.apraxia.eventapi.events.impl.player.EventUpdate;
import ua.apraxia.modules.Categories;
import ua.apraxia.modules.Module;

import java.util.Random;
public class CDLeave extends Module {
    public CDLeave() {
        super("CDLeave", Categories.Movement);
    }

    @EventTarget
    public void onPreMotion(EventUpdate event) {
        Random rand = new Random();
        int upperbound = 2500;
        int randomcords = rand.nextInt(upperbound);
        int endX = 5000 + randomcords;
        int endY = 120;
        int endZ = 5000 + randomcords;

        if (mc.player.ticksExisted % 8 == 0) {
            mc.player.connection.sendPacket((Packet) new CPacketPlayer.Position(endX + 0.51D, endY + 0.11D, endZ - 0.51D, true));
            mc.player.connection.sendPacket((Packet) new CPacketPlayer.Position(endX, endY, endZ, false));
            mc.player.connection.sendPacket((Packet) new CPacketPlayer.Position(endX + 0.54D, endY + 0.13, endZ - 0.54D, true));
            return;
        }
        if (mc.player.posX == endX && mc.player.posZ == endZ) {
            super.onDisable();
        }
    }
}
