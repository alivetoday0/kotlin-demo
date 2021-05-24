package hj.kim.kotlindemo.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.relational.core.mapping.Table

@Table("board")
class Board {

    @Id
    var boardId:Long = 0

    var title:String = ""

    var content:String = ""
}