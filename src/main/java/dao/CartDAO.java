package dao;

import model.Cart;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    public static Cart saveCart(Cart cart) {
        String sql = "INSERT INTO carts(user_id, time) VALUES (?, ?)";
        String curIdStatement = "SELECT currval(pg_get_serial_sequence('carts','id'))";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             PreparedStatement idPreparedStatement = connection.prepareStatement(curIdStatement)
        ) {
            preparedStatement.setInt(1, cart.getUserID());
            preparedStatement.setString(2, cart.getTime());
            preparedStatement.executeUpdate();
            ResultSet resultSet = idPreparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                cart.setId(id);
            }
            return cart;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void deleteCart(int cartID) {
        String sql = "DELETE FROM carts where id=?";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, cartID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List searchAllCartByUserID(int userID) {
        String sql = "SELECT * FROM carts WHERE user_id IN(?)";
        try (Connection connection = ConnectionToDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Cart> carts = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String time = resultSet.getString(3);
                carts.add(new Cart().builder()
                        .id(id)
                        .userID(userID)
                        .time(time)
                        .build());
                return carts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
