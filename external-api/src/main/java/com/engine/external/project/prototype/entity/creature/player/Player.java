package com.engine.external.project.prototype.entity.creature.player;

import com.engine.external.project.prototype.Prototype;
import com.engine.external.project.prototype.entity.CommandSender;
import com.engine.external.project.prototype.entity.creature.Creature;
import com.engine.external.project.prototype.entity.type.EntityType;
import com.engine.external.project.prototype.entity.type.PlayerStatus;

import java.util.UUID;

/**
 * Represents a Minecraft Player that can be offline and online
 *
 */
public interface Player extends CommandSender, Creature, Prototype<UUID> {

    String getName();

    PlayerStatus getStatus();

    /**
     * Gets the entity's type
     * @return entity's type
     */
    @Override
    default EntityType getType() {
        return EntityType.PLAYER;
    }

}
