drop database  if exists  blog;
create database blog;
use blog;

DROP TABLE IF EXISTS user ;
create table user(
    id int auto_increment ,
    name varchar(128) unique  not null,
    password varchar(128) not null,
    phone varchar(20),
    email varchar(128) not null,
    status int default 0,
    create_time timestamp default current_timestamp,
    primary key(id)
)ENGINE = InnoDB default charset = utf8;

DROP TABLE IF EXISTS post;
create table post(
    id int auto_increment,
    pid int default 0,
    title varchar(128) ,
    content text not null,
    user_id int not null,
    status int default 0 comment '失效 -1',
    comment_count int DEFAULT  0,
    read_count int default 0,
    favour_count int default 0,
    update_time timestamp ,
    create_time timestamp ,
    constraint post_pk primary key(id),
    constraint post_user_fk foreign key(user_id) references user(id) ON DELETE CASCADE
)ENGINE = InnoDB default charset = utf8;

DROP TABLE IF EXISTS favour;
create table favour(
		id int auto_increment,
    post_id int not null,
    user_id int not null,
    create_time timestamp default current_timestamp,
    constraint favour_pk primary key (id),
    constraint article_favour_fk foreign key(post_id)  references post(id) ON DELETE CASCADE,
    constraint user_favour_fk foreign key(user_id)  references user(id) ON DELETE CASCADE
)ENGINE = InnoDB default charset = utf8;

DROP TABLE IF EXISTS message;
create table message(
    id int primary key auto_increment,
    post_id int,
    commenter_id int,
    reminder_id int,
    message varchar(512),
    has_read int DEFAULT 0,
    create_time timestamp default current_timestamp,
    constraint post_id_fk foreign key(post_id) references post(id) on delete cascade,
    constraint commenter_id_fk foreign key(commenter_id) references user(id) ON DELETE CASCADE,
    constraint reminder_id_fk foreign key(reminder_id) references user(id) ON DELETE CASCADE
)ENGINE = InnoDB default charset = utf8;



