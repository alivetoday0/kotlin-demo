package hj.kim.kotlindemo.web.handler

import hj.kim.kotlindemo.domain.entity.Board
import hj.kim.kotlindemo.service.BoardService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class BoardHandler(private val boardService: BoardService) {

    fun welcome(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just("안녕하세요."), String::class.java)
            .switchIfEmpty(ServerResponse.notFound().build())

    fun list(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(boardService.findAll(), Board::class.java))
            .switchIfEmpty(ServerResponse.notFound().build())

    fun register(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(boardService.save(req.bodyToMono(Board::class.java)))
            .switchIfEmpty(ServerResponse.notFound().build())
}