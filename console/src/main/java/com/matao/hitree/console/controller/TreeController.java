package com.matao.hitree.console.controller;

import com.matao.hitree.module.entity.Tree;
import com.matao.hitree.module.serveice.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    private TreeService service;

    @RequestMapping("getAll")
    public List<Tree> getAll() {
        return service.getAll();
    }

    @RequestMapping("/create")
    public String create(@RequestParam String coverImages,
                         @RequestParam String treeCode,
                         @RequestParam BigDecimal price,
                         @RequestParam String variety,
                         @RequestParam String description,
                         @RequestParam Byte saleStatus,
                         @RequestParam String address,
                         @RequestParam String locationPoint) {
        Tree tree = new Tree().setCovertImages(coverImages)
                .setTreeCode(treeCode)
                .setPrice(price)
                .setVariety(variety)
                .setDescription(description)
                .setSaleStatus(saleStatus)
                .setAddress(address)
                .setLocationPoint(locationPoint);
        int result = service.create(tree);
        return result >= 1 ? "成功" : "失败";
    }

    @RequestMapping("/update")
    public String update(@RequestParam Long treeId,
                         @RequestParam String coverImages,
                         @RequestParam String treeCode,
                         @RequestParam BigDecimal price,
                         @RequestParam String variety,
                         @RequestParam String description,
                         @RequestParam Byte saleStatus,
                         @RequestParam String address,
                         @RequestParam String locationPoint) {
        Tree tree = new Tree().setId(treeId)
                .setCovertImages(coverImages)
                .setTreeCode(treeCode)
                .setPrice(price)
                .setVariety(variety)
                .setDescription(description)
                .setSaleStatus(saleStatus)
                .setAddress(address)
                .setLocationPoint(locationPoint);

        int result = service.update(tree);
        return result >= 1 ? "成功" : "失败";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long treeId) {
        int result = service.deleteById(treeId);
        return result >= 1 ? "成功" : "失败";
    }

}
