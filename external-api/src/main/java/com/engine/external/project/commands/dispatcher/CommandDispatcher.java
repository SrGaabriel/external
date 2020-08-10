package com.engine.external.project.commands.dispatcher;

import com.engine.external.project.commands.CommandContext;

public interface CommandDispatcher {

    void execute(CommandContext context);

}
