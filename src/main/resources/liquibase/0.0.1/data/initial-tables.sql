create table tbl_brand
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

create table tbl_price
(
    id         bigint generated by default as identity,
    brand_id   bigint,
    currency   varchar(255),
    end_date   timestamp,
    price      decimal(10, 2),
    price_list integer not null,
    priority   integer not null,
    product_id bigint,
    start_date timestamp,
    primary key (id)
);

create table tbl_product
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

alter table tbl_price add constraint FK4ibm55hmw9pbgah2eihbvrkeq foreign key (brand_id) references tbl_brand;
alter table tbl_price add constraint FKyctmi9k29x5wg6la6soec3gm foreign key (product_id) references tbl_product;