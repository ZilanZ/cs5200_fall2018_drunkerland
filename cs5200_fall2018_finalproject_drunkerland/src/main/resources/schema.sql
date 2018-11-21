USE `cs5200-finalproject`;

DROP TABLE IF EXISTS `sponsor`;
DROP TABLE IF EXISTS `article`;
DROP TABLE IF EXISTS `mark`;
DROP TABLE IF EXISTS `follow`;
DROP TABLE IF EXISTS `package`;
DROP TABLE IF EXISTS `item`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `stock`;
DROP TABLE IF EXISTS `wine`;
DROP TABLE IF EXISTS `reviewer`;
DROP TABLE IF EXISTS `consumer`;
DROP TABLE IF EXISTS `vendor`;
DROP TABLE IF EXISTS `supplier`;
DROP TABLE IF EXISTS `address`;
DROP TABLE IF EXISTS `user`;

-- enumeration
DROP TABLE IF EXISTS `ReviewerLevel`;
DROP TABLE IF EXISTS `OrderStatus`;
DROP TABLE IF EXISTS `PackageStatus`;

CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street1` varchar(45) DEFAULT NULL,
  `street2` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `primary` tinyint(1) DEFAULT NULL,
	`userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `user_address_composition`
		FOREIGN KEY (`userId`)
		REFERENCES `user` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `supplier` (
  `userId` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `grapeType` varchar(45) DEFAULT NULL,
  `history` varchar(45) DEFAULT NULL,
  `qualified` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`userId`),
  CONSTRAINT `user_supplier_generalization`
		FOREIGN KEY (`userId`)
		REFERENCES `user` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `vendor` (
  `userId` int(11) NOT NULL,
  `qualified` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`userId`),
  CONSTRAINT `user_vendor_generalization`
		FOREIGN KEY (`userId`)
		REFERENCES `user` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `consumer` (
  `userId` int(11) NOT NULL,
  `taste` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  CONSTRAINT `user_customer_generalization`
		FOREIGN KEY (`userId`)
		REFERENCES `user` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ReviewerLevel` (
	`id` varchar(20) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `ReviewerLevel` (`id`) VALUES ('beginner');
INSERT INTO `ReviewerLevel` (`id`) VALUES ('intermediate');
INSERT INTO `ReviewerLevel` (`id`) VALUES ('senior');

CREATE TABLE `reviewer` (
  `userId` int(11) NOT NULL,
  `level` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`userId`),
  CONSTRAINT `user_reviewer_generalization`
		FOREIGN KEY (`userId`)
		REFERENCES `user` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `level_enumeration`
		FOREIGN KEY (`level`)
		REFERENCES `ReviewerLevel` (`id`)
		ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
	`appellation` varchar(45) NOT NULL DEFAULT '',
  `color` varchar(45) DEFAULT NULL,
	`region` varchar(45) DEFAULT NULL,
	`country` varchar(45) DEFAULT NULL,
  `vintage` varchar(20) NOT NULL DEFAULT '',
	`date` date DEFAULT NULL,
	`primeurs` tinyint(1) DEFAULT 0,
  `score` FLOAT(3,2) DEFAULT 0.00,
  `supplierId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `supplier_wine_association`
		FOREIGN KEY (`supplierId`)
		REFERENCES `supplier` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `stock` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`amount` int(11) NOT NULL,
  `purchase` decimal(10,2) NOT NULL,
  `sellingPrice` decimal(10,2) NOT NULL,
  `available` tinyint(1) DEFAULT 0,
  `vendorId` int(11) DEFAULT NULL,
  `wineId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `vender_stock_association`
		FOREIGN KEY (`vendorId`)
		REFERENCES `vendor` (`userId`)
		ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wine_stock_association`
		FOREIGN KEY (`wineId`)
		REFERENCES `wine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `OrderStatus` (
	`id` varchar(20) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `OrderStatus` (`id`) VALUES ('Basket');
INSERT INTO `OrderStatus` (`id`) VALUES ('Pending');
INSERT INTO `OrderStatus` (`id`) VALUES ('Paid');
INSERT INTO `OrderStatus` (`id`) VALUES ('Canceled');
INSERT INTO `OrderStatus` (`id`) VALUES ('Refunded');

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL COMMENT 'Basket: Consumer Shopping Cart',
  `totalPrice` decimal(10,2) NOT NULL,
	`destination` varchar(255) DEFAULT NULL COMMENT 'record address when order is placed',
  `created` date DEFAULT NULL,
  `consumerId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
	CONSTRAINT `status_enum`
		FOREIGN KEY (`status`)
		REFERENCES `OrderStatus` (`id`),
	CONSTRAINT `consumer_order_association`
		FOREIGN KEY (`consumerId`)
		REFERENCES `consumer` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `item` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`qty` int(11) DEFAULT 0,
	`orderId` int(11) NOT NULL,
	`stockId` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `order_item_composition`
		FOREIGN KEY (`orderId`)
		REFERENCES `order` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `stock_item_association`
		FOREIGN KEY (`stockId`)
		REFERENCES `stock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `PackageStatus` (
	`id` varchar(20) NOT NULL DEFAULT '',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `PackageStatus` (`id`) VALUES ('Shipped');
INSERT INTO `PackageStatus` (`id`) VALUES ('In transit');
INSERT INTO `PackageStatus` (`id`) VALUES ('Delivered');
INSERT INTO `PackageStatus` (`id`) VALUES ('Returned');

CREATE TABLE `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trackingNumber` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `itemId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `package_status_enum`
		FOREIGN KEY (`status`)
		REFERENCES `PackageStatus` (`id`),
  CONSTRAINT `item_package_association`
		FOREIGN KEY (`itemId`)
		REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `follow` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`consumerId` int(11) NOT NULL,
	`reviewerId` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `consumer_follow`
		FOREIGN KEY (`consumerId`)
		REFERENCES `consumer` (`userId`)
		ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `reviewer_followed_by`
		FOREIGN KEY (`reviewerId`)
		REFERENCES `reviewer` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `mark` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`point` decimal(5,2)	NOT NULL,
	`reviewerId` int(11) NOT NULL,
	`wineId` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `reviewer_mark_association`
		FOREIGN KEY (`reviewerId`)
		REFERENCES `reviewer` (`userId`),
	CONSTRAINT `wine_mark_association`
		FOREIGN KEY (`wineId`)
		REFERENCES `wine` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `article` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`title` varchar(255) DEFAULT NULL,
	`created` date DEFAULT NULL,
	`updated` date DEFAULT NULL,
  `views` int(11) NOT NULL,
	`reviewerId` int(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `reviewer_article_association`
		FOREIGN KEY (`reviewerId`)
		REFERENCES `reviewer` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sponsor` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`wineId` int(11) NOT NULL,
	`articleId` int(11) NOT NULL,
	`supplierId` int(11) DEFAULT 0,
	PRIMARY KEY (`id`),
	CONSTRAINT `article_sponsor`
		FOREIGN KEY (`articleId`)
		REFERENCES `article` (`id`)
		ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `wine_sponsor`
		FOREIGN KEY (`wineId`)
		REFERENCES `wine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
