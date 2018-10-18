package cn.tedu.store.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;

@Service
public class AddressService implements IAddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	public List<Address> getAllAddressByUid(Integer id) {
		List<Address> addresses = addressMapper.getAddressByUid(id);
		return addresses;
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		/*String pCode = address.getRecvProvince();
		String cCode = address.getRecvCity();
		String aCode = address.getRecvArea();*/
		String district=address.getRecvProvince()+address.getRecvCity()+address.getRecvArea();
	//	String district = dictMapper.getProvinceByCode(pCode)+dictMapper.getCityByCode(cCode)+dictMapper.getAreaByCode(aCode);
		address.setRecvDistrict(district);
		if (addressMapper.getAddressByUid(address.getUid()).size() == 0) {
			address.setIsDefault(1);
		}else {
			address.setIsDefault(0);
		}
		addressMapper.insert(address);
		
	}

	@Override
	public void setDefault(Integer id, Integer uId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Address getAddressById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddress(Integer id) {
		Address address = addressMapper.getAddressById(id);
		int count = addressMapper.delete(id);
		if (count == 1) {
			if (address.getIsDefault() == 1) {
				List<Address> addresses = addressMapper.getAddressByUid(address.getUid());
				if (addresses.size() > 0) {
					int defaultId = addresses.get(0).getId();
					addressMapper.setDefault(defaultId);
				}
			}
		}
	}

}