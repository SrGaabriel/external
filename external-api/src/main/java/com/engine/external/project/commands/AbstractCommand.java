package com.engine.external.project.commands;

import java.util.List;

public abstract class AbstractCommand {

    /**
     * @since 0.1
     * @return The command's name and aliases
     */
    public abstract List<String> getLabels();

    /**
     * @since 0.1
     * @return The command's description
     */
    public abstract String getDescription();

    /**
     * Method is called every time the command is executed and the context
     * pass all the command's requirements
     *
     * @param context The context
     * @see CommandContext
     */
    public abstract void run(CommandContext context);

}
