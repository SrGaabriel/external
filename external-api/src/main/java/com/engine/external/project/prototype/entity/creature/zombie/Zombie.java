package com.engine.external.project.prototype.entity.creature.zombie;

import com.engine.external.project.prototype.entity.creature.Creature;
import com.engine.external.project.prototype.entity.type.EntityType;

/**
 * Represents a Minecraft Zombie
 *
 * @since 0.1
 */
public interface Zombie extends Creature {

    /**
     * Gets the entity's type
     * @return entity's type
     */
    @Override
    default EntityType getType() {
        return EntityType.ZOMBIE;
    }
}
