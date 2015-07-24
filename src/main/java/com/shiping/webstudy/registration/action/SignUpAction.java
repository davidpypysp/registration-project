package com.shiping.webstudy.registration.action;

import com.shiping.webstudy.registration.constant.WebConst;
import com.shiping.webstudy.registration.model.bo.UserBo;
import com.shiping.webstudy.registration.service.SystemService;
import com.shiping.webstudy.registration.service.impl.SystemServiceImpl;
import org.json.JSONException;
import org.json.JSONStringer;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by shipin on 2015/7/10.
 */
public class SignUpAction extends javax.servlet.http.HttpServlet {

    public void init() throws ServletException{

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        //get info from front-end
        System.out.println("test!");

        UserBo userbo = new UserBo();
        userbo.setUsername(request.getParameter("username"));
        userbo.setNickname(request.getParameter("nickname"));
        userbo.setPassword(request.getParameter("password"));
        userbo.setEmail(request.getParameter("email"));
        userbo.setSex(request.getParameter("sex"));





        //use service to save into mysql
        SystemService service = new SystemServiceImpl();
        String status = WebConst.SIGN_UP_STATUS_SUCCESS;
        if( service.userNameExisted(userbo.getUsername()) ) //username is used
            status = WebConst.SIGN_UP_STATUS_USERNAME_USED;
        else {
            service.signUpUser(userbo);
        }




        //return the status code
        PrintWriter out = response.getWriter();
        JSONStringer output = new JSONStringer();
        try {
            output.object().key("status").value(status).key("username").value(userbo.getUsername()).endObject();
        } catch (JSONException e) {e.printStackTrace();}
        out.print(output);




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
