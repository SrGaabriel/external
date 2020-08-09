package com.engine.external.project.utils.tasks;

import com.engine.external.project.plugin.MinecraftPlugin;

import java.time.Instant;

public class Task {

    private final MinecraftPlugin plugin;
    private Runnable runnable;

    public Task(MinecraftPlugin plugin) {
        this.plugin = plugin;
    }

    public MinecraftPlugin getPlugin() {
        return plugin;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void subscribe(Runnable runnable, Instant instant) {
        this.runnable = runnable;
        plugin.getServer().getTaskManager().schedule(this, instant);
    }

    public void subscribe(Runnable runnable, long initialDelay, long period) {
        this.runnable = runnable;
        plugin.getServer().getTaskManager().scheduleRepeating(this, initialDelay, period);
    }

}
