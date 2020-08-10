package com.engine.external.project.prototype.world;

import com.engine.external.project.prototype.world.chunk.Chunk;

import java.util.List;

public interface World {

    String getName();

    void setName(String name);

    List<Chunk> getChunks();

}
