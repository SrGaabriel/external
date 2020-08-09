package com.engine.external.project.utils.tasks.impl;

import com.engine.external.project.utils.tasks.Task;
import com.engine.external.project.utils.tasks.TaskManager;
import reactor.core.Disposable;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class TaskManagerImpl implements TaskManager {

    private final Map<Task, Disposable> tasks = new HashMap<>();
    private final Scheduler scheduler = Schedulers.newParallel("Task Scheduler");

    @Override
    public void schedule(Task task, Instant instant) {
        tasks.put(task, scheduler.schedule(task.getRunnable(), instant.toEpochMilli(), TimeUnit.MILLISECONDS));
    }

    @Override
    public void scheduleRepeating(Task task, long initialDelay, long delay) {
        tasks.put(task, scheduler.schedulePeriodically(task.getRunnable(), initialDelay, delay, TimeUnit.MILLISECONDS));
    }

    @Override
    public Scheduler getScheduler() {
        return scheduler;
    }

    @Override
    public void cancel(Task task) {
        tasks.get(task).dispose();
    }

}
