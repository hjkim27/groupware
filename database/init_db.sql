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


        
----------------------------------------------------------
-- Created      2025.08.21
-- Description  업무관리
----------------------------------------------------------
create table tb_task
(
    sid                 serial,
    title               character varying not null,
    description         text,
    status              character varying not null default 'pending',
    priority            character varying not null default 'normal',
    due_date            timestamp with time zone,
    assigned_user_sid   integer[],
    created_user_sid    integer,
    tag_sids            integer[],
    group_sid           integer,
    start_date          timestamp with time zone,
    end_date            timestamp with time zone,
    progress            integer default 0,
    is_deleted          boolean default false,
    is_archived         boolean default false,
    is_completed        boolean default false,
    is_important        boolean default false,
    created_at          timestamp with time zone default now(),
    updated_at          timestamp with time zone
);

comment on column tb_task.sid is '일련번호';
comment on column tb_task.title is  '업무제목';
comment on column tb_task.description is '업무설명';
comment on column tb_task.status is '업무상태(none, pending, in_progress, completed, cancel)';
comment on column tb_task.priority is '우선순위(low, normal, high)';
comment on column tb_task.due_date is '마감일';
comment on column tb_task.assigned_user_sid is '담당자 sid';
comment on column tb_task.created_user_sid is '생성자 sid';
comment on column tb_task.tag_sids is '태그 sid';
comment on column tb_task.group_sid is '그룹 sid';
comment on column tb_task.start_date is '시작일';
comment on column tb_task.end_date is '종료일';
comment on column tb_task.progress is '진행률';
comment on column tb_task.is_deleted is '삭제 여부';
comment on column tb_task.is_archived is '아카이브 여부';
comment on column tb_task.is_completed is '완료 여부';
comment on column tb_task.is_important is '중요 여부';
comment on column tb_task.created_at is '생성일자';
comment on column tb_task.updated_at is '수정일자';


----------------------------------------------------------
-- Created      2025.08.21
-- Description  tag
----------------------------------------------------------
create table tb_tag
(
    sid serial,
    tag_name character varying not null,
    tag_type character varying
)

comment on column tb_tag.sid is '일련번호';
comment on column tb_tag.tag_name is '태그명';
comment on column tb_tag.tag_type is '태그 타입';
