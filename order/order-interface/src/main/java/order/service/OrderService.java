package order.service;

import common.utils.MallResult;
import order.pojo.OrderInfo;

public interface OrderService {

	MallResult createOrder(OrderInfo orderInfo);
}
