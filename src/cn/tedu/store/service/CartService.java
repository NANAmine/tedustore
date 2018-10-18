package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVO;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService{
	@Autowired
CartMapper cartMapper;
	@Override
	public List<Cart> getCarts(Integer userid) {
		// TODO Auto-generated method stub
		
		List<Cart> carts=cartMapper.getCartsByUserId(userid);
		if(carts!=null)
		return carts;
		
		return null;
	}
	
	@Override
	public List<CartVO> getGoodsByUseridInCart(Integer userid) {
		return cartMapper.getGoodsByUseridInCart(userid);
	}
	@Override
	public void deleteCart(Integer cid) {
		// TODO Auto-generated method stub
		cartMapper.deleteCart(cid);
	}
	
	@Override
	public void deleteByBatch(List<Integer> listId) {
		for(Integer i : listId) {
			cartMapper.deleteById(i);
		}
	}
	
	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		cartMapper.addCart(cart);
		
	}
	@Override
	public Cart getCartsByid(Integer id) {
		// TODO Auto-generated method stub
		return cartMapper.getCartsByid(id);
	}

	@Override
	public void updateCountById(Integer id, Integer count) {
		cartMapper.updateCountById(id, count);
	}
	
	@Override
	public void deleteById(Integer id) {
		cartMapper.deleteById(id);
	}
	
	@Override
	public CartVO getcartVOById(Integer id) {
		return cartMapper.getCartVOById(id);
	}

}