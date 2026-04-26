-- auto-generated definition
create table orders
(
    id           bigint         not null,
    tenant_id    bigint         not null comment '租户id',
    order_no     varchar(64)    not null comment '订单号',
    buyer_id     bigint         not null comment '购买方用户id',
    account_id   bigint         not null comment '账户id',
    state        int            not null comment '订单状态：待支付/已支付/已取消',
    total_amount decimal(18, 2) not null comment '订单总金额',
    created_at   datetime       not null,
    updated_at   datetime       not null,
    primary key (tenant_id, id),
    constraint uk_order_no
        unique (tenant_id, order_no)
)
    comment '订单主表';

create index idx_account
    on orders (tenant_id, account_id);

create index idx_buyer
    on orders (tenant_id, buyer_id);