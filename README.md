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
1.随机生成短链接，可设置字符集和短链接长度（此处长度指http://后面的位数）  

2.支持自定义短链接  

3.访问短链接跳转到长链接  

4.支持访问计数  

5.jquery判断输入网址是否正确，判断输出长度是否为正整数  

![](https://github.com/fanshuaiko/longurltoshorturl/blob/master/images/20181101054730.png)  
![](https://github.com/fanshuaiko/longurltoshorturl/blob/master/images/20181101054811.png)  
![](https://github.com/fanshuaiko/longurltoshorturl/blob/master/images/20181101054844.png)
![](https://github.com/fanshuaiko/longurltoshorturl/blob/master/images/20181101054930.png)
![](https://github.com/fanshuaiko/longurltoshorturl/blob/master/images/20181101055959.png)
