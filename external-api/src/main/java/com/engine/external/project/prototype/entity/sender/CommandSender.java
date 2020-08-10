package com.engine.external.project.prototype.entity.sender;

import com.engine.external.project.prototype.entity.Entity;
import com.engine.external.project.prototype.entity.creature.player.Player;

import java.util.Collection;

/**
 * An entity that can execute a command and receive messages.
 *
 * @since 0.1
 * @see Player
 */
public interface CommandSender extends Entity {

    /**
     * Sends separated messages to the entity
     *
     * @since 0.1
     * @param messages The messages that this entity will receive
     */
    void sendMessage(String... messages);

    /**
     * Sends separated messages to the entity
     *
     * @since 0.1
     * @param messages The messages that this entity will receive
     */
    void sendMessage(Collection<String> messages);

    /**
     * Forces this entity to send the specified message
     * @param message The message that the entity will send
     */
    void sudo(String message);

}
