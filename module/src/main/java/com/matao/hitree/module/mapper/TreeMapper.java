package com.matao.hitree.module.mapper;

import com.matao.hitree.module.entity.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TreeMapper {

    @Select("SELECT * FROM tree WHERE id = #{id} AND is_deleted = 0")
    Tree getById(Long id);

    @Update("UPDATE tree SET is_deleted = 1, update_time = #{updateTime} where id = #{id}")
    int deleteById(Long id, int updateTime);

    @Select("SELECT * FROM tree WHERE is_deleted = 0")
    List<Tree> getAll();

    int create(Tree tree);

    int update(Tree tree);
}
