-- auto-generated definition
create table inventory_transaction
(
    id               bigint         not null,
    tenant_id        bigint         not null comment '租户id',
    biz_no           varchar(64)    not null comment '业务幂等号',
    inventory_id     bigint         not null comment '库存id',
    order_id         bigint         null comment '订单id',
    quantity         decimal(18, 6) not null comment '变动数量',
    transaction_type int            not null comment '库存流水类型：冻结/扣减/解冻/入库',
    available_before decimal(18, 6) not null comment '变动前可用库存',
    available_after  decimal(18, 6) not null comment '变动后可用库存',
    frozen_before    decimal(18, 6) not null comment '变动前冻结库存',
    frozen_after     decimal(18, 6) not null comment '变动后冻结库存',
    created_at       datetime       not null,
    primary key (tenant_id, id),
    constraint uk_biz_type
        unique (tenant_id, biz_no, transaction_type)
)
    comment '库存流水表';

create index idx_inventory
    on inventory_transaction (tenant_id, inventory_id);

create index idx_order
    on inventory_transaction (tenant_id, order_id);