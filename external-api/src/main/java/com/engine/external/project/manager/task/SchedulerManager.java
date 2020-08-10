package com.engine.external.project.manager.task;

import com.engine.external.project.prototype.task.Task;
import reactor.core.scheduler.Scheduler;

import java.util.List;

public interface SchedulerManager {

    Scheduler getScheduler();

    List<Task> getTasks();

    Task filter(int id);

    void schedule(Runnable runnable, long delay, long tick);

    void schedule(Task task, long delay, long tick);

}
