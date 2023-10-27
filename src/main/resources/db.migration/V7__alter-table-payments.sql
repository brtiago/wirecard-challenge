ALTER TABLE payments
    ADD COLUMN card_number VARCHAR(16);

ALTER TABLE payments
    ADD CONSTRAINT fk_card_number
        FOREIGN KEY (card_number)
            REFERENCES cards(card_number);