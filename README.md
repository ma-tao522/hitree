# 接口文档

## 购树APP

baseUrl：http://localhost:8080

### 1.树列表

/tree/list

参数：

返回：

```json
{
    list:[
        {
            wallImage：[String],
    		treeCode：[String],
			price：[Float],
			treeId：[Long]
        }
    ]
}
```



### 2.树详情

/tree/info

参数：

treeId：[Long]

返回：

```json
{
	coverImages：[String[]],
	treeCode：[String],
	price：[Float],
	variety：[String],
	description：[String],
	saleStatus：[Int]，
	address：[String],
	locationPoint：[String[]]
}
```



## 购树CONSOLE

baseUrl：http://localhost:8081

### 1.树新增

/tree/create

参数：
coverImages：[String]
treeCode：[String]
price：[Float]
variety：[String]
description：[String]
saleStatus：[Int]
address：[String]
locationPoint：[String]

返回：

成功 or 失败

### 2.树修改

/tree/update

参数：

treeId：[Long]
coverImages：[String]
treeCode：[String]
price：[Float]
variety：[String]
description：[String]
saleStatus：[Int]
address：[String]
locationPoint：[String]

返回：

成功 or 失败

### 3.树删除

/tree/delete

参数：

treeId：[Long]

返回：

成功 or 失败

# 数据库DDL

```sql
CREATE DATABASE IF NOT EXISTS hitree;
USE hitree;
CREATE Table IF NOT EXISTS tree
(
    'id'             BIGINT UNSIGNED                                             NOT NULL AUTO_INCREMENT,
    'covert_images'  VARCHAR(2000) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '封面图，$符拼接',
    'tree_code'      VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci   NOT NULL COMMENT '编号',
    'price'          DECIMAL(10, 2)                                           NOT NULL COMMENT '价格',
    'variety'        VARCHAR(50) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci   NOT NULL COMMENT '树品种',
    'description'    VARCHAR(2000) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '描述',
    'saleStatus'     TINYINT UNSIGNED                                         NOT NULL DEFAULT 0 COMMENT '销售状态，1未销售，2已销售，3暂停售卖',
    'address'        VARCHAR(255) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL COMMENT '地址',
    'location_point' VARCHAR(200) CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT NULL COMMENT '经纬度，经度在前，纬度在后，$符拼接',
    'create_time'    INT UNSIGNED                                             NOT NULL,
    'update_time'    INT UNSIGNED                                             NOT NULL,
    'is_deleted'     TINYINT UNSIGNED                                         NOT NULL DEFAULT '0',
    PRIMARY KEY (id),
    KEY 'idx_tree_code' ('tree_code'),
    KEY 'idx_variety' ('variety')
) ENGINE InnoDB
  DEFAULT CHARSET utf8mb4
  COLLATE utf8mb4_unicode_ci COMMENT '树表';
```

```sql
-- 插入树表模拟数据
INSERT INTO `tree` (`covert_images`, `tree_code`, `price`, `variety`, `description`, `saleStatus`, `address`,
                    `location_point`, `create_time`, `update_time`, `is_deleted`)
VALUES ('https://example.com/images/oak1.jpg$https://example.com/images/oak2.jpg', 'TREE-001', 2500.00, '橡树',
        '树龄约15年，树冠茂盛，适合庭院种植', 1, '广州市天河区珠江新城花城大道18号', '113.3245$23.1291',
        UNIX_TIMESTAMP('2025-03-10 10:00:00'), UNIX_TIMESTAMP('2026-06-19 14:30:00'), 0),

       ('https://example.com/images/maple1.jpg', 'TREE-002', 3800.00, '红枫', '秋季红叶观赏极佳，高度约4米', 2,
        '深圳市南山区科技园科苑路15号', '113.9520$22.5431', UNIX_TIMESTAMP('2025-05-20 09:15:00'),
        UNIX_TIMESTAMP('2026-06-18 16:20:00'), 0),

       ('https://example.com/images/cherry1.jpg$https://example.com/images/cherry2.jpg$https://example.com/images/cherry3.jpg',
        'TREE-003', 5200.00, '樱花', '早樱品种，开花繁茂，树形优美', 3, '杭州市西湖区杨公堤10号', '120.1552$30.2729',
        UNIX_TIMESTAMP('2024-11-01 11:00:00'), UNIX_TIMESTAMP('2026-06-17 09:00:00'), 0),

       ('https://example.com/images/pine1.jpg', 'TREE-004', 1800.00, '黑松', '常绿针叶树，耐寒耐旱，适合盆景造型', 1,
        '南京市玄武区中山陵园内', '118.8435$32.0652', UNIX_TIMESTAMP('2026-01-15 14:20:00'),
        UNIX_TIMESTAMP('2026-06-19 08:10:00'), 0),

       ('https://example.com/images/ginkgo1.jpg$https://example.com/images/ginkgo2.jpg', 'TREE-005', 6100.00, '银杏',
        '树龄20年，秋季金黄，雌株，每年结果', 2, '成都市锦江区人民南路一段86号', '104.0732$30.6586',
        UNIX_TIMESTAMP('2025-08-25 16:45:00'), UNIX_TIMESTAMP('2026-06-18 22:00:00'), 0),

       ('https://example.com/images/camphor1.jpg', 'TREE-006', 3200.00, '樟树', '常绿乔木，可提取樟脑油，树冠浓密', 1,
        '武汉市武昌区东湖路沿湖大道28号', '114.3532$30.5513', UNIX_TIMESTAMP('2025-12-02 13:30:00'),
        UNIX_TIMESTAMP('2026-06-16 11:25:00'), 0),

       ('https://example.com/images/peach1.jpg$https://example.com/images/peach2.jpg', 'TREE-007', 2700.00, '桃树',
        '观赏桃，花重瓣，粉色，适合春季观赏', 3, '苏州市姑苏区虎丘路1号', '120.5912$31.3121',
        UNIX_TIMESTAMP('2026-02-18 08:50:00'), UNIX_TIMESTAMP('2026-06-15 17:40:00'), 0),

       ('https://example.com/images/willow1.jpg', 'TREE-008', 1600.00, '垂柳', '枝条下垂，适合水边种植，生长迅速', 1,
        '南京市建邺区莫愁湖公园', '118.7654$32.0456', UNIX_TIMESTAMP('2025-09-05 10:10:00'),
        UNIX_TIMESTAMP('2026-06-14 13:15:00'), 0),

       ('https://example.com/images/magnolia1.jpg$https://example.com/images/magnolia2.jpg$https://example.com/images/magnolia3.jpg',
        'TREE-009', 4500.00, '玉兰', '早春开花，白色大花，香味浓郁', 2, '上海市黄浦区外滩中山东一路12号',
        '121.4925$31.2427', UNIX_TIMESTAMP('2025-07-11 12:00:00'), UNIX_TIMESTAMP('2026-06-19 06:30:00'), 0),

       ('https://example.com/images/osmanthus1.jpg', 'TREE-010', 2100.00, '桂花', '金桂品种，秋季花香四溢，常绿灌木', 1,
        '杭州市拱墅区丽水路88号', '120.1456$30.3198', UNIX_TIMESTAMP('2025-10-20 15:30:00'),
        UNIX_TIMESTAMP('2026-06-18 19:50:00'), 0);
```

# 测试URL

```url
http://localhost:8080/tree/list
```

```url
http://localhost:8080/tree/info?treeId=11
```

```url
http://localhost:8081/tree/create?coverImages=img1.jpg$img2.jpg&treeCode=T001&price=1999.99&variety=%E7%BD%97%E6%B1%89%E6%9D%BE&description=%E8%BF%99%E6%98%AF%E4%B8%80%E6%A3%B5%E6%BC%82%E4%BA%AE%E7%9A%84%E6%A0%91&saleStatus=1&address=%E5%B9%BF%E4%B8%9C%E7%9C%81%E5%B9%BF%E5%B7%9E%E5%B8%82%E5%A4%A9%E6%B2%B3%E5%8C%BA&locationPoint=113.123$23.456
```

```url
http://localhost:8081/tree/update?treeId=11&coverImages=img1111.jpg$img2.jpg&treeCode=T001&price=1999.99&variety=%E7%BD%97%E6%B1%89%E6%9D%BE&description=%E8%BF%99%E6%98%AF%E4%B8%80%E6%A3%B5%E6%BC%82%E4%BA%AE%E7%9A%84%E6%A0%91&saleStatus=1&address=%E5%B9%BF%E4%B8%9C%E7%9C%81%E5%B9%BF%E5%B7%9E%E5%B8%82%E5%A4%A9%E6%B2%B3%E5%8C%BA&locationPoint=113.123$23.456
```

```url
http://localhost:8081/tree/delete?treeId=11
```

