create table if not exists Book (
id identity,
title varchar(500) not null,
author varchar(200) not null,
genre varchar(200) not null,
release varchar(4) not null
);