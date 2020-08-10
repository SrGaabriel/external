package com.engine.external.project.manager

import com.engine.external.project.prototype.entity.creature.player.Player
import java.util.*

class PlayerManagerImpl: PlayerManager {

    private val onlinePlayers: MutableList<Player> = mutableListOf()

    override fun getOnlinePlayer(uniqueId: UUID): Player? =
        onlinePlayers.firstOrNull { it.uniqueId == uniqueId }

    override fun getOnlinePlayer(name: String): Player? =
        onlinePlayers.firstOrNull { it.name == name }

    override fun getOnlinePlayers(): List<Player> =
        onlinePlayers

}