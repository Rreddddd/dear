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
drop table if exists `message_board`;
CREATE TABLE `message_board` (
                            `ID`  int(8) NOT NULL AUTO_INCREMENT ,
                            `IP`  varchar(50) NOT NULL ,
                            `LOCATION`  varchar(200) NOT NULL ,
                            `CONTENT`  varchar(20000) NULL ,
                            `TIME`  datetime NOT NULL ,
                            PRIMARY KEY (`ID`)
);
drop table if exists `access_record`;
CREATE TABLE `access_record` (
                            `ID`  int(8) NOT NULL AUTO_INCREMENT ,
                            `METHOD`  varchar(50) NOT NULL ,
                            `IP`  varchar(50) NOT NULL ,
                            `LOCATION`  varchar(200) NOT NULL ,
                            `TIME`  datetime NOT NULL ,
                            PRIMARY KEY (`ID`)
);