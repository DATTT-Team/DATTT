# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table dattt (
  id                        bigint not null,
  title                     varchar(255),
  create_at                 timestamp,
  body                      varchar(255),
  location                  varchar(255),
  deadline                  timestamp,
  constraint pk_dattt primary key (id))
;

create table sharing (
  id                        varchar(255) not null,
  dattt_id                  bigint,
  user_id                   varchar(255),
  read_allowed              boolean,
  check_allowed             boolean,
  add_allowed               boolean,
  mod_allowed               boolean,
  constraint pk_sharing primary key (id))
;

create table tag (
  id                        varchar(255) not null,
  name                      varchar(255),
  info                      varchar(255),
  constraint pk_tag primary key (id))
;

create table user (
  id                        varchar(255) not null,
  email                     varchar(255),
  nick                      varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  password_hash             varchar(255),
  active                    boolean,
  email_validated           boolean,
  registered_at             timestamp,
  last_login                timestamp,
  google_account_name       varchar(255),
  constraint uq_user_nick unique (nick),
  constraint pk_user primary key (id))
;

create sequence dattt_seq;

create sequence sharing_seq;

create sequence tag_seq;

create sequence user_seq;

alter table sharing add constraint fk_sharing_dattt_1 foreign key (dattt_id) references dattt (id) on delete restrict on update restrict;
create index ix_sharing_dattt_1 on sharing (dattt_id);
alter table sharing add constraint fk_sharing_user_2 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_sharing_user_2 on sharing (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists dattt;

drop table if exists sharing;

drop table if exists tag;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists dattt_seq;

drop sequence if exists sharing_seq;

drop sequence if exists tag_seq;

drop sequence if exists user_seq;

