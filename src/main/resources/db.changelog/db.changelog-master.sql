--liquibase formatted sql
--changeset artem:1
create table users
(
    id       bigserial
        primary key,
    login    varchar(255),
    password varchar(255)
);

create table reminders
(
    id          bigserial
        primary key,
    description varchar(4096),
    remind      timestamp(6),
    title       varchar(255),
    user_id     bigint not null
        constraint fkgibc0ij0e4s7bkldn4xybaanb
            references users
);

--changeset artem:2
insert INTO users (id, login, password)
values (1, 'user1', 'passs');

insert into reminders (description, remind, title, user_id)
values ('Полное описание', '2016-06-22 19:10:25-07', 'Заголовок', 1);
