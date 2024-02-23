package com.example.le_dinh_hung_2110900025.Ledinhhung.servlet;

import com.example.le_dinh_hung_2110900025.Ledinhhung.beans.Ledinhhung_2110900025_Product;
import com.example.le_dinh_hung_2110900025.Ledinhhung.conn.LeDinhHungConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.le_dinh_hung_2110900025.Ledinhhung.utils.ledinhhung_ProductUtils;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/ledinhhung_productEdit")
public class ledinhhung_ProductEditServlet extends HttpServlet {
    public ledinhhung_ProductEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductEdit.jsp");
        String masp = req.getParameter("masp");
        if (masp == null || masp == "") {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Ledinhhung_2110900025_Product product = null;
        errorString = null;

        try {
            conn = LeDinhHungConnection.getMSSQLConnections();
            product = ledinhhung_ProductUtils.queryProduct(conn, masp);
            if (product == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + masp;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || product == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String masp = req.getParameter("masp");
        String tensp = req.getParameter("tensp");
        String soluongStr = req.getParameter("soluong");
        String dongiaStr = req.getParameter("dongia");
        String anh = req.getParameter("anh");
        int soluong = 0;
        float dongia = 0;
        try {
            dongia = Float.parseFloat(dongiaStr);
            soluong= Integer.parseInt(soluongStr);
        } catch (Exception e) {
            errorString = e.getMessage();

        }
        Ledinhhung_2110900025_Product product = new Ledinhhung_2110900025_Product(masp, tensp, soluong,dongia,anh);
        if (errorString != null ){
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductEdit.jsp");
            dispatcher.forward(req,resp);
        }
        Connection conn = null;
        try {
            conn = LeDinhHungConnection.getMSSQLConnections();
            ledinhhung_ProductUtils.updateProduct(conn,product);
            resp.sendRedirect(req.getContextPath()+"/ledinhhung_productList");

        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductEdit.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
