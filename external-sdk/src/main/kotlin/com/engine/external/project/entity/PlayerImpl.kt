package com.engine.external.project.entity

import com.engine.external.project.prototype.entity.creature.player.Player
import com.engine.external.project.prototype.entity.type.PlayerStatus
import com.engine.external.project.prototype.vector.Vector
import com.mojang.authlib.GameProfile
import java.util.*

data class PlayerImpl internal constructor(
    private val name: String,
    private val profile: GameProfile
): Player {

    private var health: Double = 20.0
    private var status: PlayerStatus = PlayerStatus.OFFLINE
    private var vector: Vector = TODO("Not yet implemented")

    /**
     * Sends separated messages to the entity
     *
     * @since 0.1
     * @param messages The messages that this entity will receive
     */
    override fun sendMessage(vararg messages: String) {
        sendMessage(messages.toList())
    }

    /**
     * Sends separated messages to the entity
     *
     * @since 0.1
     * @param messages The messages that this entity will receive
     */
    override fun sendMessage(messages: Collection<String>) {
        messages.forEach { _ ->
            // TODO Send message
        }
    }

    override fun getStatus(): PlayerStatus {
        return status
    }

    internal fun setStatus(status: PlayerStatus) {
        this.status = status
    }

    /**
     * @since 0.1
     * @return The user's health (hearths * 2)
     */
    override fun getHealth(): Double {
        return health
    }

    /**
     * @since 0.1
     * @return Player's name
     */
    override fun getName(): String {
        return name
    }

    override fun getVector(): Vector {
        return vector
    }

    /**
     * @since 0.1
     * @return Player's UUID/unique id
     */
    override fun getUniqueId(): UUID {
        return profile.id
    }

    override fun setVector(vector: Vector) {
        this.vector = vector
    }

    override fun setHealth(health: Double) {
        this.health = health
    }

    /**
     * Forces this entity to send the specified message
     * @param message The message that the entity will send
     */
    override fun sudo(message: String) {
        TODO("Not yet implemented")
    }
}