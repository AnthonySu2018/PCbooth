package com.anthony.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

var taskText ="No task."
fun Application.configureRouting() {
    routing {
        get("/"){
            taskText = "No task."
            call.respondText("""
                Visit http://127.0.0.1:8080 to stop shutting down laptops.
                Visit http://127.0.0.1:8080/shutdown to shutdown laptops.
                Done.taskText is $taskText now.
            """.trimIndent()
            )

        }
        get("/shutdown"){
            taskText = "shutdown"
            call.respondText("""
                Visit http://127.0.0.1:8080 to stop shutting down laptops.
                Visit http://127.0.0.1:8080/shutdown to shutdown laptops.
                Done.taskText is $taskText now.
            """.trimIndent()
            )

        }
        get("/task") {
            call.respondText(taskText)
        }
    }
}
