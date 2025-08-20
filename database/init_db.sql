----------------------------------------------------------
-- Created      2025.07.31
-- Description  사용자정보
----------------------------------------------------------
create table tb_user
(
    sid                 serial,
    login_id            character varying not null,
    password            character varying not null,
    name                character varying,
    email               character varying,
    birth               character varying,
    phone               character varying,
    position            character varying,
    group_sid           integer,
    role                character varying,
    auth_level          integer                  default 0,
    created_at          timestamp with time zone default now(),
    updated_at          timestamp with time zone,
    password_expired_at timestamp with time zone default now()
);

comment on column tb_user.sid is '일련번호';
comment on column tb_user.login_id is '아이디';
comment on column tb_user.password is '비밀번호';
comment on column tb_user.name is '이름';
comment on column tb_user.email is '이메일';
comment on column tb_user.birth is '생년월일';
comment on column tb_user.phone is '전화번호';
comment on column tb_user.position is '직급';
comment on column tb_user.group_sid is '그룹 sid';
comment on column tb_user.role is '역할(admin, user)';
comment on column tb_user.auth_level is '권한수준';
comment on column tb_user.created_at is '생성일자';
comment on column tb_user.updated_at is '수정일자';
comment on column tb_user.password_expired_at is '비밀번호 만료일자';

