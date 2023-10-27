ALTER TABLE payments
    ALTER COLUMN card_id SET DATA TYPE bigint USING card_id::bigint;

ALTER TABLE payments ADD CONSTRAINT fk_card_id
    FOREIGN KEY (card_id)
        REFERENCES cards(id);
