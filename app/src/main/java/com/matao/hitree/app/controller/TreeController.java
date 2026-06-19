package com.matao.hitree.app.controller;

import com.matao.hitree.app.domain.TreeInfoVo;
import com.matao.hitree.app.domain.TreeListFeedVo;
import com.matao.hitree.app.domain.TreeListVo;
import com.matao.hitree.module.entity.Tree;
import com.matao.hitree.module.serveice.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    private TreeService service;

    @RequestMapping("/list")
    public TreeListVo list() {
        List<Tree> trees = service.getAll();
        List<TreeListFeedVo> feeds = new ArrayList<>(trees.size());
        for (Tree tree : trees) {
            TreeListFeedVo feed = new TreeListFeedVo();
            feed.setWallImage(List.of(tree.getCovertImages().split("\\$")).get(0))
                    .setTreeCode(tree.getTreeCode()).setPrice(tree.getPrice())
                    .setTreeId(tree.getId());
            feeds.add(feed);
        }
        TreeListVo result = new TreeListVo();
        result.setList(feeds);
        return result;
    }

    @RequestMapping("/info")
    public TreeInfoVo info(@RequestParam Long treeId) {
        Tree tree = service.getById(treeId);
        TreeInfoVo result = new TreeInfoVo();
        result.setCovertImages(List.of(tree.getCovertImages().split("\\$")))
                .setTreeCode(tree.getTreeCode())
                .setPrice(tree.getPrice())
                .setVariety(tree.getVariety())
                .setDescription(tree.getDescription())
                .setSaleStatus(tree.getSaleStatus())
                .setAddress(tree.getAddress())
                .setLocationPoint(List.of(tree.getLocationPoint().split("\\$")));
        return result;
    }
}
