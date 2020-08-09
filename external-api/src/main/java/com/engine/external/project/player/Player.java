package com.engine.external.project.player;

import com.engine.external.project.network.Packet;

public interface Player {

    String getName();

    void sendPacket(Packet packet);

}
