package com.engine.external.project.stream.buffer;

public interface ByteBuffer {

    int readInt(int size);

    long readLong();

    short readShort();

    byte readByte();

    boolean readBoolean();

    float readFloat();

    double readDouble();

    String readString(boolean size);

}
