ALTER TABLE cards
    ADD CONSTRAINT uk_card_number UNIQUE (card_number);