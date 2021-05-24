package hj.kim.kotlindemo.service

import hj.kim.kotlindemo.domain.entity.Board
import hj.kim.kotlindemo.domain.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Service
class BoardService(private val boardRepository: BoardRepository) {

    @Transactional
    fun save(board: Mono<Board>): Mono<Board> = board.flatMap { boardRepository.save(it) }

    @Transactional(readOnly = true)
    fun findAll() = boardRepository.findAll()
}