package com.shiping.webstudy.registration.dao;

import com.shiping.webstudy.registration.model.po.UserPo;

/**
 * Created by shipin on 2015/7/11.
 */
public interface SystemDao {
    /**
     * find if the userName exist in db
     * @param username
     * @return true if exist
     */
    boolean userNameExisted(String username);

    /**
     * insert a new user into db
     * @param userpo
     * @return
     */
    boolean insertUser(UserPo userpo);

    /**
     * find a user by its name
     * @param username
     * @return po if exist, null if not
     */


    /**
     * update user's data
     * @param userpo
     * @return
     */
    boolean updateUser(UserPo userpo);

    /**
     * get user by name
     * @param username
     * @return
     */
    UserPo getUserByName(String username);
}
