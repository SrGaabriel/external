package com.engine.external.project.plugin;

import com.engine.external.project.ExternalServer;

public abstract class MinecraftPlugin {

    private String name;
    private ExternalServer server;

    public abstract void start();

    public abstract void shutdown();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExternalServer getServer() {
        return server;
    }
}
