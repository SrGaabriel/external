package com.engine.external.project.prototype.world;

import com.engine.external.project.prototype.world.chunk.Chunk;

import java.util.List;

/**
 * Represents a minecraft world
 *
 * @see Chunk
 * @since 0.1
 */
public interface World {

    /**
     * Gets the world's name
     *
     * @return world's name
     * @since 0.1
     */
    String getName();

    /**
     * Sets the world's name
     *
     * @since 0.1
     * @param name new name
     */
    void setName(String name);

    /**
     * Retrieve all <b>loaded</b> chunks
     *
     * @since 0.1
     * @return all loaded chunks
     */
    List<Chunk> getChunks();

}
