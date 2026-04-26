-- auto-generated definition
create table inventory
(
    id              bigint         not null,
    tenant_id       bigint         not null comment '租户id',
    sku_id          bigint         not null comment '商品sku id',
    available_stock decimal(18, 6) not null comment '可用库存',
    frozen_stock    decimal(18, 6) not null comment '冻结库存',
    version         int default 0  not null comment '版本号',
    created_at      datetime       not null,
    updated_at      datetime       not null,
    primary key (tenant_id, id),
    constraint uk_sku
        unique (tenant_id, sku_id)
)
    comment '库存表';