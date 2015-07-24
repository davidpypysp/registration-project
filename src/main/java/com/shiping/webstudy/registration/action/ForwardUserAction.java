package com.shiping.webstudy.registration.action;

import com.shiping.webstudy.registration.model.bo.UserBo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shipin on 2015/7/13.
 */
public class ForwardUserAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserBo userbo = (UserBo) request.getSession().getAttribute("user");

        String page = "management.jsp";
        if(userbo == null) {
            page = "user_error.jsp";
        }
        RequestDispatcher view = request.getRequestDispatcher(page);
        view.forward(request, response);
    }
}
