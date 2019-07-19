create table comment (
comment_no bigint(19) not null auto_increment,
user_id varchar(32) not null,
comment_content mediumtext not null,
reg_date datetime not null,
primary key (comment_no),
unique key XPKnwc_comment (comment_no)
);

create table reply (
reply_no bigint(19) not null auto_increment,
comment_no bigint(19) not null,
user_id varchar(32) not null,
reply_content varchar(300) not null,
reg_date datetime not null,
primary key (reply_no),
unique key XPKnwc_reply (reply_no)
);

create table user (
user_id varchar(32) not null,
user_name varchar(100) not null,
primary key (user_id)
);