DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS productVariant;

CREATE TABLE product
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    onlineId  VARCHAR(250) NOT NULL,
    name      VARCHAR(250) NOT NULL,
    pageTitle VARCHAR(250) NOT NULL,
    urlName   VARCHAR(250) NULL,
    metaData  VARCHAR(250) NULL
);

CREATE TABLE productVariant
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    onlineId     VARCHAR(250)   NOT NULL,
    name         VARCHAR(250)   NOT NULL,
    erpId        VARCHAR(250)   NOT NULL,
    images       VARCHAR(250)   NOT NULL,
    downloads    VARCHAR(250)   NOT NULL,
    deliveryTime INTEGER        NOT NULL,
    price        DECIMAL(20, 2) NOT NULL,
    orderId      INTEGER        NOT NULL
);
