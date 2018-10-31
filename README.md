# longurltoshorturl

### 创建数据库sql:

######    DROP TABLE IF EXISTS `urlentity`;  
######    CREATE TABLE `urlentity`  (  
######    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',  
######    `longurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '长链接',  
######    `shorturl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短链接',  
######    `shorturlencode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短链接字符集',  
######    `shorturllength` int(11) NULL DEFAULT NULL COMMENT '短链接长度',  
######    `visit_count` int(11) NULL DEFAULT NULL COMMENT '访问次数',  
######    PRIMARY KEY (`id`) USING BTREE  
######  )   

实现功能：  
1.随机生成短链接，可设置字符集和短链接长度（此处指http://后面的位数）  
！
2.自己手动设置短链接  
