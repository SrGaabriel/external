package com.engine.external.project

import com.engine.external.project.stream.bootstrap.manager.PipelineManager
import org.koin.core.context.startKoin
import org.koin.dsl.module

class External {

    fun main(args: Array<String>) {
        startKoin {
            modules(
                module(createdAtStart = true) {
                    single { PipelineManager() }
                }
            )
        }
    }

}