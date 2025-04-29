package com.Jdbc.JdbcEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

public class OrderDao {
	public void addOrder(Orders orders) {
		String query = "INSERT INTO orders (item, quantity) values (?, ?)";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, orders.getItem());
			stmt.setInt(2, orders.getQuantity());
			stmt.executeUpdate();
			System.out.println("Order Added Successfully.");
			DBConn.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Orders getOrderById(int id) {
		String query = "SELECT * FROM orders WHERE id=?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Orders(rs.getString("item"), rs.getInt("quantity"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateOrderQuantity(int quantity, int id) {
		String query = "UPDATE orders SET quantity = ? WHERE id = ?";
		try (Connection conn = DBConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, quantity);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Order status updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Orders> getAllOrders() {
		List<Orders> orders = new ArrayList<Orders>();
		String query = "SELECT * FROM orders";
		try (Connection conn = DBConn.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				orders.add(new Orders(rs.getString("item"), rs.getInt("quantity")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
