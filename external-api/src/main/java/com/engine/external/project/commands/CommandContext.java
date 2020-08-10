package com.engine.external.project.commands;

import com.engine.external.project.prototype.entity.CommandSender;
import com.engine.external.project.prototype.entity.creature.player.Player;

import java.util.List;

/**
 * A command situation. Is instanced every time a {@link AbstractCommand} is called;
 *
 * @since 0.1
 * @see AbstractCommand
 */
public class CommandContext {

    private final CommandSender sender;
    private final AbstractCommand command;
    private final List<String> args;

    /**
     * @since 0.1
     * @param sender The entity that executed the {@link AbstractCommand}
     * @param command The command that was executed by the sender
     * @param args The arguments that the {@link CommandSender} specified
     */
    public CommandContext(CommandSender sender, AbstractCommand command, List<String> args) {
        this.sender = sender;
        this.command = command;
        this.args = args;
    }

    /**
     * @since 0.1
     * @return The entity that executed the {@link AbstractCommand}
     */
    public CommandSender getSender() {
        return sender;
    }

    /**
     * @since 0.1
     * @return The arguments that the {@link CommandSender} specified
     */
    public List<String> getArgs() {
        return args;
    }

    /**
     * @since 0.1
     * @return The executed {@link AbstractCommand}
     */
    public AbstractCommand getCommand() {
        return command;
    }

    /**
     * @since 0.1
     * @param index The argument's position
     * @return The argument at the specified index
     */
    public String getArgument(int index) {
        return args.get(index);
    }

    /**
     * Checks if the sender is a {@link Player}
     *
     * @since 0.1
     * @return True if the sender is a type of {@link Player}
     */
    public boolean isExecutedByPlayer() {
        return sender instanceof Player;
    }

}
