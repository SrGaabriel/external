package com.engine.external.project

import com.engine.external.project.event.EventManager
import com.engine.external.project.event.EventManagerImpl
import com.engine.external.project.scheduler.SchedulerManagerImpl
import com.engine.external.project.schedulers.SchedulerManager
import com.engine.external.project.server.Server

object External: Server {

    private var eventManager: EventManager = EventManagerImpl()
    private var schedulerManager: SchedulerManager = SchedulerManagerImpl()

    @JvmStatic
    fun main(args: Array<String>) {
        println(getLogo())
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

    private fun getLogo(): String {
        return """
                                                                                          .---. 
       __.....__                                   __.....__                _..._             |   | 
   .-''         '.                             .-''         '.            .'     '.           |   | 
  /     .-''"'-.  `.                     .|   /     .-''"'-.  `. .-,.--. .   .-.   .          |   | 
 /     /________\   \ ____     _____   .' |_ /     /________\   \|  .-. ||  '   '  |    __    |   | 
 |                  |`.   \  .'    / .'     ||                  || |  | ||  |   |  | .:--.'.  |   | 
 \    .-------------'  `.  `'    .' '--.  .-'\    .-------------'| |  | ||  |   |  |/ |   \ | |   | 
  \    '-.____...---.    '.    .'      |  |   \    '-.____...---.| |  '- |  |   |  |`" __ | | |   | 
   `.             .'     .'     `.     |  |    `.             .' | |     |  |   |  | .'.''| | |   | 
     `''-...... -'     .'  .'`.   `.   |  '.'    `''-...... -'   | |     |  |   |  |/ /   | |_'---' 
                     .'   /    `.   `. |   /                     |_|     |  |   |  |\ \._,\ '/      
                    '----'       '----'`'-'                              '--'   '--' `--'  `"       
        """.trimIndent()
    }

}