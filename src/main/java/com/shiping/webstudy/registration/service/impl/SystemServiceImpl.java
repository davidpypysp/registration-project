package com.shiping.webstudy.registration.service.impl;

import com.shiping.webstudy.registration.dao.SystemDao;
import com.shiping.webstudy.registration.dao.impl.SystemDaoImpl;
import com.shiping.webstudy.registration.model.bo.UserBo;
import com.shiping.webstudy.registration.model.po.UserPo;
import com.shiping.webstudy.registration.service.SystemService;

/**
 * Created by shipin on 2015/7/12.
 */
public class SystemServiceImpl implements SystemService {
    @Override
    public boolean userNameExisted(String username) {
        boolean flag = false;
        SystemDao sd = new SystemDaoImpl();
        if(sd.userNameExisted(username)) flag = true;
        return flag;
    }

    @Override
    public boolean signUpUser(UserBo userbo) {
        boolean flag = false;
        UserPo userpo = userbo.convertPo();
        SystemDao sd = new SystemDaoImpl();
        if(sd.insertUser(userpo))
            flag = true;
        return flag;
    }

    @Override
    public UserBo loginUser(UserBo userbo) {
        SystemDao sd = new SystemDaoImpl();
        UserPo userpo = sd.getUserByName(userbo.getUsername());
        if(userbo.getPassword().equals(userpo.getPassword()))
            return userpo.convertBo();
        return null;
    }

    @Override
    public boolean updateUser(UserBo userbo) {
        SystemDao sd = new SystemDaoImpl();
        return sd.updateUser(userbo.convertPo());
    }
}
