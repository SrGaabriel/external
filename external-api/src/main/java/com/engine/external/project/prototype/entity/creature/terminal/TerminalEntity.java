package com.engine.external.project.prototype.entity.creature.terminal;

import com.engine.external.project.prototype.entity.CommandSender;
import com.engine.external.project.prototype.entity.type.EntityType;
import com.engine.external.project.prototype.vector.Vector;

public interface TerminalEntity extends CommandSender {

    @Override
    default void setVector(Vector vector) {
        throw new UnsupportedOperationException("Can't set terminal's vector");
    }

    @Override
    default Vector getVector() {
        throw new UnsupportedOperationException("Can't set terminal's vector");
    }

    @Override
    default EntityType getType() {
        return EntityType.TERMINAL;
    }

}
