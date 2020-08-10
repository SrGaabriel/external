package com.engine.external.project.stream.packet;

import io.netty.buffer.ByteBuf;

public interface Packet {

    int getID();

    void write(ByteBuf buffer);

    void read(ByteBuf buffer);

}
