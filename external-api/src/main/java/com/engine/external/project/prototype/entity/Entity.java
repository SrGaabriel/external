package com.engine.external.project.prototype.entity;

import com.engine.external.project.prototype.entity.type.EntityTypes;
import com.engine.external.project.prototype.vector.Vector;

public interface Entity {

    EntityTypes getType();

    void setType(EntityTypes type);

    Vector getVector();

    void setVector(Vector vector);

}
