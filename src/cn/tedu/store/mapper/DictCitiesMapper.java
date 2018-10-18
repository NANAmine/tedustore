package cn.tedu.store.mapper;

import cn.tedu.store.bean.DictCities;

public interface DictCitiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictCities record);

    int insertSelective(DictCities record);

    DictCities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictCities record);

    int updateByPrimaryKey(DictCities record);
}