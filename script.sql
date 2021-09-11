create sequence cart_cart_id_seq
    as integer;

alter sequence cart_cart_id_seq owner to postgres;

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
    phone_number text        not null,
    login        varchar(20) not null,
    password     varchar(20) not null
);

alter table customer
    owner to postgres;

create unique index user_user_id_uindex
    on customer (user_id);

create unique index customer_login_uindex
    on customer (login);

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
    id         serial
        constraint logbook_pk
            primary key,
    user_login varchar(20) not null,
    product_id integer     not null,
    count      integer     not null
);

alter table logbook
    owner to postgres;


