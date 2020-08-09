package com.engine.external.project.tasks

import com.engine.external.project.utils.tasks.Task
import com.engine.external.project.utils.tasks.TaskManager
import reactor.core.Disposable
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.time.Instant
import java.util.concurrent.TimeUnit

class TaskManagerImpl : TaskManager {

    private val tasks: MutableMap<Task, Disposable> = HashMap()

    private val scheduler = Schedulers.newParallel("Task Scheduler")

    override fun schedule(
        task: Task,
        instant: Instant
    ) {
        tasks[task] = scheduler.schedule(task.runnable, instant.toEpochMilli(), TimeUnit.MILLISECONDS)
    }

    override fun scheduleRepeating(
        task: Task,
        initialDelay: Long,
        delay: Long
    ) {
        tasks[task] = scheduler.schedulePeriodically(task.runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
    }

    override fun getScheduler(): Scheduler =
        scheduler

    override fun cancel(task: Task): Unit =
        tasks[task]!!.dispose()

}
