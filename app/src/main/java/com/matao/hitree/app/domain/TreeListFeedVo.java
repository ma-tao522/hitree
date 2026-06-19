package com.matao.hitree.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class TreeListFeedVo {
    private Long treeId;
    private String wallImage;
    private String treeCode;
    private BigDecimal price;
}
