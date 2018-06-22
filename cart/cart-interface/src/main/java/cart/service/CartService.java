package cart.service;

import java.util.List;

import common.utils.MallResult;
import pojo.TbItem;

public interface CartService {

    MallResult addCart(long userId, long itemId, int num);
    MallResult mergeCart(long userId, List<TbItem> itemList);
	List<TbItem> getCartList(long userId);
    MallResult updateCartNum(long userId, long itemId, int num);
    MallResult deleteCartItem(long userId, long itemId);
    MallResult clearCartItem(long userId);
}
