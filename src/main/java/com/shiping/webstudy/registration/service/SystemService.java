package com.shiping.webstudy.registration.service;

import com.shiping.webstudy.registration.model.bo.UserBo;

/**
 * Created by shipin on 2015/7/12.
 */
public interface SystemService {
    /**
     * check whether the username is used
     * @param username
     * @return true if used
     */
    boolean userNameExisted(String username);

    /**
     * sign up new user, save it into db
     * @param userbo
     * @return success or fail
     */
    boolean signUpUser(UserBo userbo);

    /**
     * login user, failed if user's password is invalid
     * @param userbo
     * @return true: success, false: password invalid;
     */
    UserBo loginUser(UserBo userbo);

    /**
     * update user's data.
     * @param userbo
     * @return new userbo
     */
    boolean updateUser(UserBo userbo);
}
