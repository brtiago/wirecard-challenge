create table payments(
    id bigint not null generated always as identity,
    client_id bigint not null,
    buyer_id bigint not null,
    amount numeric(10, 2),
    payment_type varchar(20),
    datetime timestamp DEFAULT CURRENT_TIMESTAMP,
    payment_status varchar(20),

    primary key(id),
    CONSTRAINT fk_client_id
        FOREIGN KEY (client_id)
            REFERENCES clients(id),


    CONSTRAINT fk_buyer_id
        FOREIGN KEY (buyer_id)
            REFERENCES buyers(id)

);