package com.engine.external.project.prototype.entity;

import com.engine.external.project.prototype.entity.type.EntityType;
import com.engine.external.project.prototype.vector.Vector;

/**
 * An entity represents a minecraft entity
 *
 * Give a look at {@inheritDoc https://minecraft.gamepedia.com/Entity}
 */
public interface Entity {

    /**
     * Gets the entity's type
     * @return entity's type
     */
    EntityType getType();

    Vector getVector();

    void setVector(Vector vector);

}
