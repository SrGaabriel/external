package com.engine.external.project.tasks

import com.engine.external.project.utils.tasks.Task
import com.engine.external.project.utils.tasks.TaskManager
import org.jetbrains.annotations.NotNull
import reactor.core.Disposable
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.time.Instant
import java.util.concurrent.TimeUnit

class TaskManagerImpl : TaskManager {

    private val tasks: MutableMap<Task, Disposable> = HashMap()
    private val scheduler = Schedulers.newParallel("Task Scheduler")

    /**
     * Scheduling a task that will run <b>once</b> to a specific [Instant]
     *
     * @param task The task that will be scheduled
     * @param instant The time that the scheduler will execute the task
     */
    override fun schedule(
        task: Task,
        instant: Instant
    ) {
        tasks[task] = scheduler.schedule(task.runnable, instant.toEpochMilli(), TimeUnit.MILLISECONDS)
    }

    /**
     * Scheduling a task that will run <b>multiple times</b> to a specific [Instant]
     *
     * @since 0.1.0
     *
     * @param task The task that will be scheduled
     * @param initialDelay Time that the scheduler will wait to start executing the task
     * @param delay The interval/period that the scheduler will execute the task
     */
    override fun schedule(
        task: Task,
        initialDelay: Long,
        delay: Long
    ) {
        tasks[task] = scheduler.schedulePeriodically(task.runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * @return The task scheduler
     */
    override fun getScheduler(): Scheduler =
        scheduler

    /**
     * Cancels a task that was running / was scheduled
     *
     * @param task The task that will be cancelled
     */
    override fun cancel(task: Task): Unit =
        tasks[task]!!.dispose()

}
