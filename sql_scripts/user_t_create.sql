CREATE TABLE `user_t` (
  `UserID` int(11) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `Password` varchar(15) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Image` varchar(45) DEFAULT NULL,
  `Admin` tinyint(4) DEFAULT NULL,
  `DateCreated` date DEFAULT NULL,
  `Balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8