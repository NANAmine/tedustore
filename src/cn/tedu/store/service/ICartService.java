package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVO;
import cn.tedu.store.bean.Goods;

public interface ICartService {

	List<Cart> getCarts(Integer userid);

	void deleteCart(Integer cid);

	void deleteByBatch(List<Integer> listId);

	void addCart(Cart cart);

	Cart getCartsByid(Integer id);

	List<CartVO> getGoodsByUseridInCart(Integer userid);

	void updateCountById(Integer id, Integer count);

	void deleteById(Integer id);

	CartVO getcartVOById(Integer id);

}