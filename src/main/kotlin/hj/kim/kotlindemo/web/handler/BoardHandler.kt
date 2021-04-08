package hj.kim.kotlindemo.web.handler

import hj.kim.kotlindemo.domain.entity.Board
import hj.kim.kotlindemo.domain.repository.BoardRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxOperator
import reactor.core.publisher.Mono

@Component
class BoardHandler(val boardRepository: BoardRepository) {

    fun welcome(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(Mono.just("안녕하세요."), String::class.java)
            .switchIfEmpty(ServerResponse.notFound().build())

    fun list(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(boardRepository.findAll(), Board::class.java))
            .switchIfEmpty(ServerResponse.notFound().build())

    fun register(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(boardRepository.save(req.bodyToMono(Board::class.java)))
}