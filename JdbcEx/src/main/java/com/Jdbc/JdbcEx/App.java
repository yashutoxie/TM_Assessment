package com.Jdbc.JdbcEx;

public class App {
	public static void main(String[] args) {
		Orders o1 = new Orders("Phone", 1);
		Orders o2 = new Orders("Laptop", 2);
		

		OrderDao orderDao = new OrderDao();
		orderDao.addOrder(o1);
		orderDao.addOrder(o2);

		System.out.println(orderDao.getOrderById(1));

		orderDao.updateOrderQuantity(2, 1);

		for (Orders order : orderDao.getAllOrders()) {
			System.out.println(order);
		}

	}

}
