CREATE TABLE board (
    board_id bigint unsigned not null auto_increment primary key,
    title varchar(500) not null,
    content text not null
);