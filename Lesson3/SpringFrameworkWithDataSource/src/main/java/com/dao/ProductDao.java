package com.dao;

import com.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertProductInfo(Product product) {
        try {
            return jdbcTemplate.update("insert into product values (?,?,?)", product.getPid(), product.getPname(), product.getPrice());
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public List<Product> getAllProducts() {
        try {
            return jdbcTemplate.query("select * from product", (ResultSet rs, int rowNum) -> {
                Product p = new Product();
                p.setPid(rs.getInt(1));
                p.setPrice(rs.getFloat(3));
                p.setPname(rs.getString(2));
                return p;
            });
        } catch (Exception e) {
            System.out.println();
            return new ArrayList<>();
        }
    }

//    @Autowired
//    DataSource ds; // Search the database connection in XML file
//
//    public int insertProductInfo(Product product) {
//        try {
//            Connection con = ds.getConnection();
//            PreparedStatement pstmt = con.prepareStatement("insert  into product values (?,?,?)");
//            pstmt.setInt(1,product.getPid());
//            pstmt.setString(2,product.getPname());
//            pstmt.setFloat(3,product.getPrice());
//            int res = pstmt.executeUpdate();
//            return res;
//        } catch (Exception e){
//            System.out.println(e);
//            return 0;
//        }
//    }
//
//    public List<Product> getAllProduct() {
//        List<Product> lsitOfProduct = new ArrayList<>();
//        try {
//            Connection con = ds.getConnection();
//            PreparedStatement pstmt = con.prepareStatement("select * from product");
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                Product p = new Product();
//                p.setPid(rs.getInt(1));
//                p.setPrice(rs.getFloat(3));
//                p.setPname(rs.getString(2));
//                lsitOfProduct.add(p);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return lsitOfProduct;
//    }
}