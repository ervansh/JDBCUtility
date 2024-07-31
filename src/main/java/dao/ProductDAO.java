package dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import dataModels.Product;

public class ProductDAO extends GenericDAO<Product> {

    @Override
    protected Product mapResultSetToEntity(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }

    public Product getProductById(int id) {
        String query = "SELECT * FROM products WHERE id = " + id;
        return executeQuery(query).stream().findFirst().orElse(null);
    }
}
