package com.engine.external.project

import org.kodein.di.*

class External : ExternalServer() {

    override fun start() {
        injection = DI {
            bind<ExternalServer>() with singleton { this@External }
        }

    }

    companion object {

        lateinit var injection: DI

    }

}

fun main() {
    External().start()
}