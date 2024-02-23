package com.example.le_dinh_hung_2110900025.Ledinhhung.servlet;

import com.example.le_dinh_hung_2110900025.Ledinhhung.beans.Ledinhhung_2110900025_Product;
import com.example.le_dinh_hung_2110900025.Ledinhhung.conn.LeDinhHungConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.example.le_dinh_hung_2110900025.Ledinhhung.utils.ledinhhung_ProductUtils;
@WebServlet("/ledinhhung_productList")
public class ledinhhung_ProductListServlet extends HttpServlet {
    public ledinhhung_ProductListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        List<Ledinhhung_2110900025_Product> list = null;
        try {
            conn = LeDinhHungConnection.getMSSQLConnections();
            try {
                list = ledinhhung_ProductUtils.queryProduct(conn);

            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();

            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("productList", list);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductList.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            errorString = e1.getMessage();
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductList.jsp");
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
