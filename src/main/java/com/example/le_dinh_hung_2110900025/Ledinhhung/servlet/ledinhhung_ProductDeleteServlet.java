package com.example.le_dinh_hung_2110900025.Ledinhhung.servlet;

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

@WebServlet("/ledinhhung_productDelete")
public class ledinhhung_ProductDeleteServlet extends HttpServlet {
    public ledinhhung_ProductDeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorString = null;
        String masp = req.getParameter("masp");
        Connection conn = null;
        try {
            conn = LeDinhHungConnection.getMSSQLConnections();
            ledinhhung_ProductUtils.deleteProduct(conn,masp);
        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString != null){
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/ledinhhung_ProductDelete.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/ledinhhung_productList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
