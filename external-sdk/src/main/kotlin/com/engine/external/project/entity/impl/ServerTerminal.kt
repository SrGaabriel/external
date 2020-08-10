package com.engine.external.project.entity.impl

import com.engine.external.project.log.ConsoleInputController
import com.engine.external.project.prototype.entity.creature.terminal.TerminalEntity
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.slf4j.Logger

class ServerTerminal: TerminalEntity, KoinComponent {

    private val logger by inject<Logger>()
    private val consoleManager by inject<ConsoleInputController>()

    override fun sendMessage(vararg messages: String) {
        sendMessage(messages.toList())
    }

    override fun sendMessage(messages: Collection<String>) {
        messages.forEach {
            logger.info(it)
        }
    }

    override fun sudo(message: String) {
    }

}