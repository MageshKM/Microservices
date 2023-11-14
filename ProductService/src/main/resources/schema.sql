CREATE TABLE `Product_Detail` (
  `product_id` bigint auto_increment PRIMARY KEY,
  `product_name` varchar(50),
  `batch_id` bigint
);

CREATE TABLE `Batch_Detail` (
  `batch_id` bigint auto_increment PRIMARY KEY,
  `supplier_id` bigint,
  `quanity` int,
  `rate` int,
  `payment_status` varchar(15)
);

CREATE TABLE `Supplier_Detail` (
  `supplier_id` bigint auto_increment PRIMARY KEY,
  `supplier_name` varchar(100),
  `supplier_address` varchar(255),
  `supplier_city` varchar(50),
  `supplier_state` varchar(50),
  `supplier_zipcode` varchar(6),
  `supplier_contact` int
);

CREATE TABLE `Order_Detail` (
  `order_id` bigint auto_increment PRIMARY KEY,
  `customer_id` bigint,
  `product_id` bigint,
  `order_quantity` bigint,
  `order_status` varchar(15)
);

CREATE TABLE `Customer_Detail` (
  `customer_id` bigint auto_increment PRIMARY KEY,
  `customer_name` varchar(100),
  `customer_address` varchar(255),
  `customer_city` varchar(50),
  `customer_zipcode` varchar(6),
  `customer_state` varchar(50),
  `customer_phone` integer
);

ALTER TABLE `Product_Detail` ADD FOREIGN KEY (`batch_id`) REFERENCES `Batch_Detail` (`batch_id`);

ALTER TABLE `Batch_Detail` ADD FOREIGN KEY (`supplier_id`) REFERENCES `Supplier_Detail` (`supplier_id`);

ALTER TABLE `Order_Detail` ADD FOREIGN KEY (`customer_id`) REFERENCES `Customer_Detail` (`customer_id`);
