package com.engine.external.project.schedulers;

import reactor.core.scheduler.Scheduler;

import java.util.List;

public interface SchedulerManager {

    void schedule(Runnable task, long delay);

    void schedule(Runnable task, long initialDelay, long period);

    Scheduler getScheduler();

    List<Runnable> getTasks();

    void cancel(Runnable task);

}
