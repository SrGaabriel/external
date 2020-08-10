package com.engine.external.project.stream.bootstrap

import com.engine.external.project.stream.bootstrap.manager.PipelineManager
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class KBootstrap (private val port: Int, private val nThreads: Int): KoinComponent {

    private val logger: Logger = LoggerFactory.getLogger("KBootstrap");
    private val pipeline by inject<PipelineManager>();

    init {
        logger.info("KBootstrap initialized in PORT: {}", port);
    }

    fun submit() {
        val loop: EventLoopGroup = NioEventLoopGroup(nThreads);

        val server: ServerBootstrap = ServerBootstrap()
            .group(loop)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(object : ChannelInitializer<SocketChannel>() {
                override fun initChannel(ch: SocketChannel) {
                    pipeline.with(1).forEach { ch.pipeline().addLast(it) }

                    pipeline.with(0).forEach { ch.pipeline().addFirst(it) }
                }
            })

            .option(ChannelOption.SO_KEEPALIVE, true)
            .childOption(ChannelOption.TCP_NODELAY, true);

        val future: ChannelFuture = server.bind( port).sync();

        logger.info("KBootstrap was solved. The channel's handler are working.")

    }



}