package com.matao.hitree.module.serveice;

import com.matao.hitree.module.entity.Tree;
import com.matao.hitree.module.mapper.TreeMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TreeService {

    @Resource
    private TreeMapper mapper;

    public Tree getById(Long id) {
        log.info("获取数据详情：" + id);
        return mapper.getById(id);
    }

    public int deleteById(Long id) {
        log.info("删除数据：" + id);
        int updateTime = (int) (System.currentTimeMillis() / 1000);
        return mapper.deleteById(id, updateTime);
    }

    public List<Tree> getAll() {
        log.info("获取所有数据");
        return mapper.getAll();
    }

    public int create(Tree tree) {
        int currentTime = (int) (System.currentTimeMillis() / 1000);
        tree.setCreateTime(currentTime);
        tree.setUpdateTime(currentTime);
        tree.setIsDeleted((byte) 0);
        log.info("新增数据：" + tree);
        return mapper.create(tree);
    }

    public int update(Tree tree) {
        int currentTime = (int) (System.currentTimeMillis() / 1000);
        tree.setUpdateTime(currentTime);
        log.info("修改数据：" + tree);
        return mapper.update(tree);
    }
}
