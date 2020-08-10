package com.engine.external.project.stream.bootstrap.manager

import io.netty.channel.ChannelHandler

class PipelineManager {

    private val storage: MutableMap<ChannelHandler, Int> = mutableMapOf();

    fun getStorage() : MutableMap<ChannelHandler, Int> = storage;

    fun with(priority: Int): MutableList<ChannelHandler> {
        val list: MutableList<ChannelHandler> = mutableListOf();

        storage.forEach { (t, u) ->
            if(u == priority) list.add(t);
        }; return list;
    }
}