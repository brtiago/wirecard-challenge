create table cards(
    id bigint not null generated always as identity,
    buyer_id bigint not null,
    holder_name varchar(100) not null,
    card_number varchar(16) not null,
    expiration_date varchar(4) not null,
    cvv varchar(3) not null,
    issuer varchar(100) not null,


    primary key(id),

    CONSTRAINT fk_buyer_id
        FOREIGN KEY (buyer_id)
            REFERENCES buyers(id)

);