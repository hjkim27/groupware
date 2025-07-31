----------------------------------------------------------
-- Created      2025.07.31
-- Description  사용자정보
----------------------------------------------------------
create table tb_user
(
    sid        serial,
    login_id   character varying not null,
    password   character varying not null,
    email      character varying,
    login_keep boolean                  default false,
    birth      character varying,
    created_at timestamp with time zone default now(),
    updated_at timestamp with time zone
);

