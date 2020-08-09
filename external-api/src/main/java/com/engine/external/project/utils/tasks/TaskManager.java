package com.engine.external.project.utils.tasks;

import reactor.core.scheduler.Scheduler;

import java.time.Instant;

public interface TaskManager {

    void schedule(Task task, Instant instant);

    void scheduleRepeating(Task task, long initialDelay, long delay);

    Scheduler getScheduler();

    void cancel(Task task);

}
