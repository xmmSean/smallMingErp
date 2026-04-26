-- auto-generated definition
create table order_item
(
    id           bigint         not null,
    tenant_id    bigint         not null comment '租户id',
    order_id     bigint         not null comment '订单id',
    inventory_id bigint         not null comment '库存id',
    sku_id       bigint         not null comment '商品sku id',
    quantity     decimal(18, 6) not null comment '购买数量',
    unit_price   decimal(18, 2) not null comment '单价',
    total_amount decimal(18, 2) not null comment '明细总金额',
    created_at   datetime       not null,
    primary key (tenant_id, id)
)
    comment '订单明细表';

create index idx_inventory
    on order_item (tenant_id, inventory_id);

create index idx_order
    on order_item (tenant_id, order_id);

create index idx_sku
    on order_item (tenant_id, sku_id);