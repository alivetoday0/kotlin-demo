package hj.kim.kotlindemo.domain.repository

import hj.kim.kotlindemo.domain.entity.Board
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface BoardRepository: R2dbcRepository<Board, Long> {
}