package com.shiping.webstudy.registration.action;

import com.shiping.webstudy.registration.constant.WebConst;
import com.shiping.webstudy.registration.model.bo.UserBo;
import com.shiping.webstudy.registration.service.SystemService;
import com.shiping.webstudy.registration.service.impl.SystemServiceImpl;
import org.json.JSONException;
import org.json.JSONStringer;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by shipin on 2015/7/11.
 */
public class LoginAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request parameter from front-end
        UserBo userbo = new UserBo();
        userbo.setUsername(request.getParameter("username"));
        userbo.setPassword(request.getParameter("password"));

        if( request.getParameter("keep").equals("on") ) {//keep user, so save cookie
            Cookie cookie = new Cookie("username", userbo.getUsername());
            cookie.setMaxAge(7 * 24  * 3600);
            response.addCookie(cookie);
        }



        //check username existing and password correctness
        String status = WebConst.LOGIN_STATUS_SUCCESS;
        SystemService service = new SystemServiceImpl();
        if( service.userNameExisted(userbo.getUsername()) == false )
            status = WebConst.LOGIN_STATUS_USERNAME_NOT_EXIST;
        else {
            userbo = service.loginUser(userbo);
            if(userbo == null)
                status = WebConst.LOGIN_STATUS_PASSWORD_INVALID;
            else {
                HttpSession session = request.getSession();
                session.setAttribute("user", userbo);
            }
        }





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
        this.doPost(request, response);
    }
}
