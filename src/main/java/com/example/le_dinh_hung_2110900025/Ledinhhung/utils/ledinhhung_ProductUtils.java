package com.example.le_dinh_hung_2110900025.Ledinhhung.utils;

import com.example.le_dinh_hung_2110900025.Ledinhhung.beans.Ledinhhung_2110900025_Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ledinhhung_ProductUtils {
    public static List<Ledinhhung_2110900025_Product> queryProduct(Connection conn )throws SQLException {
        String sql ="SELECT a.MaSP_2110900025, a.TenSP_2110900025 , a.SoLuong_2110900025, a.DonGia_2110900025, a.Anh_2110900025 FROM Ledinhhung_2110900025_Product a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Ledinhhung_2110900025_Product> list = new ArrayList<Ledinhhung_2110900025_Product>();
        while (rs.next()){
            String masp = rs.getString("MaSP_2110900025");
            String tensp = rs.getString("TenSP_2110900025");
            int soluong = rs.getInt("SoLuong_2110900025");
            String anh = rs.getString("Anh_2110900025");
            float dongia = rs.getFloat("DonGia_2110900025");
            Ledinhhung_2110900025_Product product = new Ledinhhung_2110900025_Product();
            product.setMasp(masp);
            product.setTensp(tensp);
            product.setSoluong(soluong);
            product.setAnh(anh);
            product.setDongia(dongia);
            list.add(product);

        }
        return list;

    }
    public static Ledinhhung_2110900025_Product queryProduct(Connection conn, String masp )throws SQLException{
        String sql ="SELECT a.MaSP_2110900025, a.TenSP_2110900025 , a.SoLuong_2110900025, a.DonGia_2110900025, a.Anh_2110900025 FROM Ledinhhung_2110900025_Product  a WHERE a.MaSP_2110900025 = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, masp);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String tensp = rs.getString("TenSP_2110900025");
            int soluong = rs.getInt("SoLuong_2110900025");
            String anh = rs.getString("Anh_2110900025");
            float dongia = rs.getFloat("DonGia_2110900025");
            Ledinhhung_2110900025_Product product = new Ledinhhung_2110900025_Product();
            product.setMasp(masp);
            product.setTensp(tensp);
            product.setSoluong(soluong);
            product.setAnh(anh);
            product.setDongia(dongia);
            return product;
        }
        return null;
    }

    public static void  insertProduct(Connection conn, Ledinhhung_2110900025_Product product) throws SQLException{
        String sql ="INSERT INTO Ledinhhung_2110900025_Product (MaSP_2110900025, TenSP_2110900025, SoLuong_2110900025,DonGia_2110900025,Anh_2110900025) VALUES (?,?,?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getMasp());
        pstm.setString(2, product.getTensp());
        pstm.setInt(3, product.getSoluong());
        pstm.setFloat(4, product.getDongia());
        pstm.setString(5, product.getAnh());
        pstm.executeUpdate();
    }

    public  static void updateProduct (Connection conn , Ledinhhung_2110900025_Product product) throws  SQLException{
        String sql= "UPDATE Ledinhhung_2110900025_Product SET TenSP_2110900025 = ? , SoLuong_2110900025 =? , DonGia_2110900025 =? , Anh_2110900025 =? WHERE MaSP_2110900025 =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getTensp());
        pstm.setInt(2, product.getSoluong());
        pstm.setFloat(3, product.getDongia());
        pstm.setString(4, product.getAnh());
        pstm.setString(5, product.getMasp());
        pstm.executeUpdate();
    }
    public  static void deleteProduct (Connection conn , String masp) throws  SQLException{
        String sql= "DELETE FROM Ledinhhung_2110900025_Product WHERE MaSP_2110900025 =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,masp);
        pstm.executeUpdate();
    }
}
