-- user=root, password=Test_123
Create database reviewDB;
Create table `review`(
    `productId` VARCHAR(100) NOT NULL, 
    `rating` int(1) NOT NULL,
    `customerId` VARCHAR(100) NOT NULL,
    primary key (`productId`)
);
