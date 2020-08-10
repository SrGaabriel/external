package com.engine.external.project.prototype.entity.creature.villager;

import com.engine.external.project.prototype.entity.creature.Creature;
import com.engine.external.project.prototype.entity.type.EntityType;

public interface Villager extends Creature {

    /**
     * Gets the entity's type
     * @return entity's type
     */
    @Override
    default EntityType getType() {
        return EntityType.VILLAGER;
    }
}
