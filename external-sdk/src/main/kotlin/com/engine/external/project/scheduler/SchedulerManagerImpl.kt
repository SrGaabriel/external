package com.engine.external.project.scheduler

import com.engine.external.project.schedulers.SchedulerManager
import reactor.core.Disposable
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.time.Instant
import java.util.concurrent.TimeUnit

class SchedulerManagerImpl: SchedulerManager {

    private val tasks: MutableMap<Runnable, Disposable> = HashMap()
    private val scheduler = Schedulers.newParallel("Task Scheduler")

    override fun schedule(
        runnable: Runnable,
        delay: Long
    ) {
        tasks[runnable] = scheduler.schedule(runnable, delay, TimeUnit.MILLISECONDS)
    }

    override fun schedule(
        runnable: Runnable,
        initialDelay: Long,
        delay: Long
    ) {
        tasks[runnable] = scheduler.schedulePeriodically(runnable, initialDelay, delay, TimeUnit.MILLISECONDS)
    }

    override fun getScheduler(): Scheduler =
        scheduler

    override fun getTasks(): MutableList<Runnable> =
        tasks.keys.toMutableList()

}