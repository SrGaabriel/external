package com.engine.external.project.stream.packet;

import com.engine.external.project.stream.buffer.ByteBuffer;

public interface Packet {

    int getID();

    void toRead(ByteBuffer buffer);

    void toWrite(ByteBuffer buffer);



}
