CREATE TABLE `accounts` (
  `accountnumber` varchar(50) NOT NULL,
  `accounttype` varchar(50) NOT NULL,
  `creditcardnumber` varchar(50) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  PRIMARY KEY (`accountnumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customers` (
  `username` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phonenumber` varchar(12) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `id` bigint(20) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(400) NOT NULL,
  `ssn` varchar(50) NOT NULL,
  `income` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `promotions` (
  `promo_code` varchar(12) NOT NULL,
  `id` int(11) NOT NULL,
  `promo_desc` varchar(400) DEFAULT NULL,
  `promo_expiration_ts` datetime NOT NULL,
  PRIMARY KEY (`promo_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;