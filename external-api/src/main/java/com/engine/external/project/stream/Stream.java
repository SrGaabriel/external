package com.engine.external.project.stream;

import java.util.function.Consumer;

public interface Stream {

    <T> void listen(int protocol, Class<T> packet, Consumer<T> consumer);

}
