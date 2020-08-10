package com.engine.external.project.manager

import com.engine.external.project.schedulers.SchedulerManager
import reactor.core.Disposable
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.TimeUnit

class SchedulerManagerImpl: SchedulerManager {

    private val tasks: MutableMap<Runnable, Disposable> = HashMap()
    private val scheduler = Schedulers.newParallel("Task Scheduler")

    /**
     * Scheduling a task that will run **once** to a specific time
     *
     * @since 0.1
     *
     * @param runnable The code that will be executed
     * @param delay The time that the scheduler will wait to execute the task
     */
    override fun schedule(
        runnable: Runnable,
        delay: Long
    ) {
        tasks[runnable] = scheduler.schedule(runnable, delay, TimeUnit.MILLISECONDS)
    }

    /**
     * Scheduling a task that will run **multiple times** to a specific time
     *
     * @since 0.1
     *
     * @param runnable The code that will be executed
     * @param initialDelay The time that the scheduler will wait to start executing the task
     * @param period The interval/period that the scheduler will execute the task
     */
    override fun schedule(
        runnable: Runnable,
        initialDelay: Long,
        period: Long
    ) {
        tasks[runnable] = scheduler.schedulePeriodically(runnable, initialDelay, period, TimeUnit.MILLISECONDS)
    }

    /**
     * @since 0.1
     * @return The task scheduler
     */
    override fun getScheduler(): Scheduler =
        scheduler

    override fun getTasks(): MutableList<Runnable> =
        tasks.keys.toMutableList()

    /**
     * Cancels a task that is scheduled
     *
     * @param task The task that will be cancelled
     */
    override fun cancel(task: Runnable): Unit =
        tasks[task]?.dispose().run { Unit }

}