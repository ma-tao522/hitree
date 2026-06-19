package com.matao.hitree.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@Accessors(chain = true)
public class TreeInfoVo {
    private List<String> covertImages;
    private String treeCode;
    private BigDecimal price;
    private String variety;
    private String description;
    private Byte saleStatus;
    private String address;
    private List<String> locationPoint;
}
