-- auto-generated definition
create table account
(
    id             bigint         not null,
    tenant_id      bigint         not null comment '租户id',
    user_id        bigint         not null comment '用户id',
    balance        decimal(18, 2) not null comment '可用余额',
    frozen_balance decimal(18, 2) not null comment '冻结余额',
    version        int default 0  not null comment '版本号',
    created_at     datetime       not null,
    updated_at     datetime       not null,
    primary key (tenant_id, id),
    constraint uk_user_account
        unique (tenant_id, user_id)
)
    comment '账户表';