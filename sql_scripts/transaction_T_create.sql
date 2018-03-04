CREATE TABLE `transaction_t` (
  `TransactionID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `TransactionDate` date DEFAULT NULL,
  `GameID` int(11) NOT NULL,
  `Bet` int(11) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8