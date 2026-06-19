package com.matao.hitree.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Tree {
    private Long id;
    private String covertImages;
    private String treeCode;
    private BigDecimal price;
    private String variety;
    private String description;
    private Byte saleStatus;
    private String address;
    private String locationPoint;
    private Integer createTime;
    private Integer updateTime;
    private Byte isDeleted;
}
