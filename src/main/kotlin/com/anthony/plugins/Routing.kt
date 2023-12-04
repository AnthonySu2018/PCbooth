package com.anthony.plugins

import com.sun.jdi.event.MonitorWaitedEvent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.apache.tomcat.jni.Time
import java.lang.ProcessBuilder.Redirect

var taskText ="No task."
fun Application.configureRouting() {
    routing {
        get("/"){
            call.respondText("""
                Visit http://127.0.0.1:8080/stoptask to stop shutting down laptops.
                Visit http://127.0.0.1:8080/shutdown to shutdown laptops.
                Now.taskText is $taskText .
            """.trimIndent()
            )
        }
        get("/stoptask"){
            taskText = "No task."
            call.respondText("""
                Visit http://127.0.0.1:8080/stoptask to stop shutting down laptops.
                Visit http://127.0.0.1:8080/shutdown to shutdown laptops.
                Now.taskText is $taskText .
            """.trimIndent()
            )

        }
        get("/shutdown"){
            taskText = "shutdown"
            call.respondText("""
                Visit http://127.0.0.1:8080/stoptask to stop shutting down laptops.
                Visit http://127.0.0.1:8080/shutdown to shutdown laptops.
                Now.taskText is $taskText .
            """.trimIndent()
            )

        }
        get("/task") {
            call.respondText(taskText)
        }
    }
}
