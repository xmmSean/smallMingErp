-- auto-generated definition
create table account_transaction
(
    id               bigint         not null,
    tenant_id        bigint         not null comment '租户id',
    biz_no           varchar(64)    not null comment '业务幂等号',
    account_id       bigint         not null comment '账户id',
    order_id         bigint         null comment '订单id',
    amount           decimal(18, 2) not null comment '变动金额',
    transaction_type int            not null comment '账户流水类型：支付/退款/冻结/解冻',
    direction        int            not null comment '方向：收入/支出',
    balance_before   decimal(18, 2) not null comment '变动前可用余额',
    balance_after    decimal(18, 2) not null comment '变动后可用余额',
    frozen_before    decimal(18, 2) not null comment '变动前冻结余额',
    frozen_after     decimal(18, 2) not null comment '变动后冻结余额',
    status           int            not null comment '流水状态',
    created_at       datetime       not null,
    primary key (tenant_id, id),
    constraint uk_biz_type
        unique (tenant_id, biz_no, transaction_type)
)
    comment '账户流水表';

create index idx_account
    on account_transaction (tenant_id, account_id);

create index idx_order
    on account_transaction (tenant_id, order_id);