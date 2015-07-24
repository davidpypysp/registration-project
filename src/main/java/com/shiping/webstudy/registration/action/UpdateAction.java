package com.shiping.webstudy.registration.action;

import com.shiping.webstudy.registration.constant.WebConst;
import com.shiping.webstudy.registration.model.bo.UserBo;
import com.shiping.webstudy.registration.service.SystemService;
import com.shiping.webstudy.registration.service.impl.SystemServiceImpl;
import org.json.JSONException;
import org.json.JSONStringer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by shipin on 2015/7/13.
 */
public class UpdateAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBo userbo = (UserBo) session.getAttribute("user");
        userbo.setNickname(request.getParameter("nickname"));
        userbo.setEmail(request.getParameter("email"));
        userbo.setSex(request.getParameter("sex"));

        String status = WebConst.UPDATE_STATUS_SUCCESS;
        SystemService service = new SystemServiceImpl();
        if( service.updateUser(userbo) == false )
            status = WebConst.UPDATE_STATUS_FAILED;
        else
            session.setAttribute("user", userbo);


        PrintWriter out = response.getWriter();
        JSONStringer output = new JSONStringer();
        try {
            output.object().key("status").value(status).endObject();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        out.print(output);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
