drop table if exists `dear_birthday_twenty_start`;
CREATE TABLE `dear_birthday_twenty_start` (
                                              `ID`  int(8) NOT NULL AUTO_INCREMENT ,
                                              `USER_NAME`  varchar(1000) NOT NULL ,
                                              `PASSWORD`  varchar(1000) NOT NULL ,
                                              `VALID`  bit NOT NULL ,
                                              `TIME`  datetime NOT NULL ,
                                              PRIMARY KEY (`ID`)
);
drop table if exists `dear_birthday_twenty_view`;
CREATE TABLE `dear_birthday_twenty_view` (
                                             `ID`  int(8) NOT NULL AUTO_INCREMENT ,
                                             `STATE`  bit(1) NOT NULL ,
                                             `TIME`  datetime NOT NULL ,
                                             PRIMARY KEY (`ID`)
);