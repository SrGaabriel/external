package com.engine.external.project

import com.engine.external.project.entity.impl.ServerTerminal
import com.engine.external.project.event.EventManager
import com.engine.external.project.event.EventManagerImpl
import com.engine.external.project.log.ConsoleInputController
import com.engine.external.project.manager.SchedulerManagerImpl
import com.engine.external.project.prototype.entity.creature.terminal.TerminalEntity
import com.engine.external.project.schedulers.SchedulerManager
import com.engine.external.project.server.Server
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.get
import org.koin.dsl.module
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.Executors

object External: Server, KoinComponent {

    private var eventManager: EventManager = EventManagerImpl()
    private var schedulerManager: SchedulerManager = SchedulerManagerImpl()

    @JvmStatic
    fun main(args: Array<String>) {
        startKoin {
            modules(module {
                single<TerminalEntity> {
                    ServerTerminal()
                }
                single<Logger> {
                    LoggerFactory.getLogger(External::class.java)
                }
                single {
                    ConsoleInputController()
                }
                single {
                    CoroutineScope(Executors.newFixedThreadPool(1).asCoroutineDispatcher() + Job())
                }
            })
        }

        get<ConsoleInputController>().init()
    }

    /**
     * @since 0.1
     * @return The server's {@link EventManager}
     */
    override fun getEventManager(): EventManager =
        eventManager

    /**
     * Overrides the current server' {@link EventManager}
     *
     * @since 0.1
     * @param eventManager The new event manager
     */
    override fun setEventManager(eventManager: EventManager) {
        this.eventManager = eventManager
    }

    /**
     * @since 0.1
     * @return The server's {@link SchedulerManager}
     */
    override fun getSchedulerManager(): SchedulerManager =
        schedulerManager

    /**
     * Overrides the current server's {@link SchedulerManager}
     *
     * @since 0.1
     * @param schedulerManager The new scheduler manager
     */
    override fun setSchedulerManager(schedulerManager: SchedulerManager) {
        this.schedulerManager = schedulerManager
    }

}