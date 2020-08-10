package com.engine.external.project.manager;

import com.engine.external.project.prototype.entity.creature.player.Player;

import java.util.Collection;
import java.util.UUID;

public interface PlayerManager {

    Player getOnlinePlayer(UUID uniqueId);

    Player getOnlinePlayer(String name);

    Collection<Player> getOnlinePlayers();

}
