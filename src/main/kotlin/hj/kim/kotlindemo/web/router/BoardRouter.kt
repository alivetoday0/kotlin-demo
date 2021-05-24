package hj.kim.kotlindemo.web.router

import hj.kim.kotlindemo.web.handler.BoardHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class BoardRouter(val boardHandler: BoardHandler) {

    @Bean
    fun borderRouter() =
            RouterFunctions.nest(RequestPredicates.path("/board"),
                    router { listOf(
                        GET("/", boardHandler::welcome),
                        POST("/", boardHandler::register),
                        GET("/list", boardHandler::list)
                    )}
            )
}