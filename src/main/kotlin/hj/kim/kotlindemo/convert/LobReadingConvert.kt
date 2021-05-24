package hj.kim.kotlindemo.convert

import hj.kim.kotlindemo.domain.entity.Board
import io.r2dbc.spi.Row
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter

/**
 * @sample https://docs.spring.io/spring-data/r2dbc/docs/1.0.0.RC1/reference/html/#mapping.explicit.converters
 */
@ReadingConverter
class LobReadingConvert : Converter<Row, Board> {

    override fun convert(source: Row): Board? {
        return Board()
    }
}