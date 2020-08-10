package com.engine.external.project.log

import com.engine.external.project.prototype.entity.creature.terminal.TerminalEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.get
import java.util.*

class ConsoleInputController: KoinComponent {

    private val terminal = get<TerminalEntity>()

    fun init() = get<CoroutineScope>().launch {
        loop(Scanner(System.`in`))
    }

    private fun loop(scanner: Scanner) {
        print("> ")
        val input = scanner.nextLine()

        if (input.trim().isEmpty()) {
            loop(scanner)
        }

        terminal.sudo(input); loop(scanner)
    }


}