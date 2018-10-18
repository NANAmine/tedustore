package cn.tedu.store.mapper;

import cn.tedu.store.bean.DictAreas;

public interface DictAreasMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictAreas record);

    int insertSelective(DictAreas record);

    DictAreas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictAreas record);

    int updateByPrimaryKey(DictAreas record);
}