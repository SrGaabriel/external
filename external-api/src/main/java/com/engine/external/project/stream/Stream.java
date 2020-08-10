package com.engine.external.project.stream;

import com.engine.external.project.stream.packet.Packet;

import java.util.function.Consumer;

public interface Stream {

    <T extends Packet> void listen(int protocol, Class<T> packet, Consumer<T> consumer);

}
