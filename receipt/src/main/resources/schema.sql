CREATE TABLE IF NOT EXISTS `receipt` (
    `receipt_id` VARCHAR(36) PRIMARY KEY ,  -- UUID stored as a string
    `retailer` VARCHAR(20) NOT NULL,        -- JSON stored as a text field
    `purchase_date` DATE NOT NULL,
    `purchase_time` TIME NOT NULL,
    `items` CLOB NOT NULL DEFAULT '[]',
    `total` DOUBLE PRECISION NOT NULL,
    `points` DOUBLE PRECISION NOT NULL
);
--
-- CREATE TABLE IF NOT EXISTS `item` (
--     `item_id` VARCHAR(36) PRIMARY KEY ,  -- UUID stored as a string
--     `receipt_id` VARCHAR(36) NOT NULL,  -- foreign key
--     `description` varchar(200) NOT NULL,
--     `price` DOUBLE PRECISION NOT NULL,
-- )
