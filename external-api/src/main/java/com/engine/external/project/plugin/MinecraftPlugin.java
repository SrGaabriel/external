package com.engine.external.project.plugin;

import com.engine.external.project.ExternalServer;

public abstract class MinecraftPlugin {

    private final String name;
    private final ExternalServer server;

    public MinecraftPlugin(String name, ExternalServer server) {
        this.name = name;
        this.server = server;
    }

    public abstract void start();

    public abstract void shutdown();

    public String getName() {
        return name;
    }

    public ExternalServer getServer() {
        return server;
    }
}
