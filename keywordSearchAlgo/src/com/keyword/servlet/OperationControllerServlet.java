package com.keyword.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keyword.pojo.RecordObject;
import com.keyword.search.service.impl.PerformOperationServiceImpl;

@WebServlet(name = "keywordSearch", urlPatterns = "")
public class OperationControllerServlet extends HttpServlet {

    // this method is used to call search operation 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parameter = req.getParameter("inputString");

        PerformOperationServiceImpl service = new PerformOperationServiceImpl();
        List<RecordObject> searchResults = service.search(parameter);
        req.setAttribute("searchResults", searchResults);
        RequestDispatcher view = req.getRequestDispatcher("welcome.jsp");
        view.forward(req, resp);

    }
    
    // this method is used to call the delete operation and update the result list after that

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recordId = req.getParameter("recordId");

        PerformOperationServiceImpl service = new PerformOperationServiceImpl();
        service.deleteComment(Integer.parseInt(recordId));
        List<RecordObject> searchResults = service.getAllComments();
        req.setAttribute("searchResults", searchResults);
        RequestDispatcher view = req.getRequestDispatcher("welcome.jsp");
        view.forward(req, resp);
    }

}