package cn.tedu.store.mapper;

import java.util.List;


import cn.tedu.store.bean.DictAreas;
import cn.tedu.store.bean.DictCities;
import cn.tedu.store.bean.DictProvinces;

public interface DictMapper {

	List<DictProvinces> getProvinces();
	List<DictCities> getCities(String provinceCode);
	List<DictAreas> getAreas(String cityCode);
	String  getProvinceByCode(String code);
	String  getCityByCode(String code);
	String  getAreaByCode(String code);
}








