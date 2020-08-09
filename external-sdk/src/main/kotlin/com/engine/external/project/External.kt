package com.engine.external.project

import com.engine.external.project.event.EventManager
import com.engine.external.project.events.EventManagerImpl
import com.engine.external.project.tasks.TaskManagerImpl
import com.engine.external.project.utils.tasks.TaskManager
import org.kodein.di.*

class External : ExternalServer() {

    private var eventManager: EventManager = EventManagerImpl()
    private var taskManager: TaskManager = TaskManagerImpl()

    override fun start() {
        val injection = DI {
            bind<ExternalServer>() with singleton { this@External }
        }
    }

    override fun getEventManager(): EventManager =
        eventManager

    override fun setEventManager(eventManager: EventManager) {
        this.eventManager = eventManager
    }

    override fun getTaskManager(): TaskManager =
        taskManager

    override fun setTaskManager(taskManager: TaskManager) {
        this.taskManager = taskManager
    }

}

fun main() {
    External().start()
}