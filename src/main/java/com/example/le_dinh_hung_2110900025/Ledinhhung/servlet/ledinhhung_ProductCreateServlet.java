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

@WebServlet("/ledinhhung_productCreate")
public class ledinhhung_ProductCreateServlet extends HttpServlet {
    public ledinhhung_ProductCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductCreate.jsp");
        dispatcher.forward(req, resp);
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
        String regex = "\\w+";
        if (masp == null || !masp.matches(regex)) {
            errorString = "Product Code invalid";
        }
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductCreate.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        try {
            conn = LeDinhHungConnection.getMSSQLConnections();
            ledinhhung_ProductUtils.insertProduct(conn, product);
            resp.sendRedirect(req.getContextPath() + "/ledinhhung_productList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductCreate.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
