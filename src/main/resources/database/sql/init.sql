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
drop table if exists `member`;
CREATE TABLE `member` (
                            `ID`  int(8) NOT NULL ,
                            `GUID`  char(36) NOT NULL ,
                            `NAME`  varchar(100) NOT NULL ,
                            `HEAD_IMG_URL`  varchar(2000) NOT NULL DEFAULT '' ,
                            `WX_OPEN_ID`  varchar(200) NULL ,
                            PRIMARY KEY (`ID`),
                            UNIQUE INDEX `index1` (`WX_OPEN_ID`) USING HASH
);
drop table if exists `member_login_info`;
CREATE TABLE `member_login_info` (
                            `ID`  int(8) NOT NULL ,
                            `MEMBER_ID`  int(8) NOT NULL ,
                            `IP`  varchar(50) NOT NULL ,
                            `LOCATION`  varchar(200) NOT NULL ,
                            `STATE`  bit NOT NULL ,
                            `FROM`  int(2) NOT NULL ,
                            `TIME`  datetime NOT NULL ,
                            PRIMARY KEY (`ID`),
                            INDEX `index1` (`MEMBER_ID`) USING BTREE
);
drop table if exists `member_im_record`;
CREATE TABLE `member_im_record` (
                            `ID`  int(8) NOT NULL ,
                            `MERGE_MEMBER_ID`  char(36) NOT NULL ,
                            `FROM_MEMBER_ID`  int(8) NOT NULL ,
                            `TO_MEMBER_ID`  int(8) NOT NULL ,
                            `CONTENT`  varchar(20000) NOT NULL DEFAULT '' ,
                            `TIME`  datetime NOT NULL ,
                            `READ`  bit NOT NULL DEFAULT 0,
                            `TYPE`  int(2) NOT NULL ,
                            PRIMARY KEY (`ID`),
                            INDEX `index1` (`MERGE_MEMBER_ID`) USING BTREE
);