create table product
(
    product_id    serial
        constraint product_pk
            primary key,
    title         varchar(40) not null,
    description   varchar(300),
    price         integer     not null,
    category      varchar(20) not null,
    stock_balance integer     not null
);

alter table product
    owner to postgres;

create unique index product_product_id_uindex
    on product (product_id);

create table purchase
(
    purchase_id     serial
        constraint purchase_pk
            primary key,
    delivery        varchar(150) not null,
    payment_amount  integer      not null,
    purchase_status varchar(40)  not null,
    user_id         integer      not null
);

alter table purchase
    owner to postgres;

create unique index purchase_purchase_id_uindex
    on purchase (purchase_id);

create table customer
(
    user_id      serial
        constraint user_pk
            primary key,
    name         varchar(20) not null,
    surname      varchar(40) not null,
    address      varchar(150),
    phone_number text        not null
);

alter table customer
    owner to postgres;

create unique index user_user_id_uindex
    on customer (user_id);

create table ticket
(
    ticket_id     serial
        constraint ticket_pk
            primary key,
    message_text  text        not null,
    priority      varchar(30) not null,
    ticket_status varchar(30) not null,
    user_id       integer     not null
);

alter table ticket
    owner to postgres;

create unique index ticket_ticket_id_uindex
    on ticket (ticket_id);

create table logbook
(
    id          serial
        constraint logbook_pk
            primary key,
    purchase_id integer not null,
    product_id  integer not null,
    number      integer not null
);

alter table logbook
    owner to postgres;

create table cart
(
    purchase_id     integer not null
        constraint cart_pk
            primary key,
    purchase_amount integer not null
);

alter table cart
    owner to postgres;

create unique index cart_purchase_id_uindex
    on cart (purchase_id);

