package com.engine.external.project.prototype.entity.creature.player;

import com.engine.external.project.prototype.Prototype;
import com.engine.external.project.prototype.entity.sender.CommandSender;
import com.engine.external.project.prototype.entity.creature.Creature;
import com.engine.external.project.prototype.entity.type.EntityType;

import java.util.UUID;

public interface Player extends CommandSender, Creature, Prototype<UUID> {

    String getName();

    /**
     * Gets the entity's type
     * @return entity's type
     */
    @Override
    default EntityType getType() {
        return EntityType.PLAYER;
    }

}
