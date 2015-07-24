package com.shiping.webstudy.registration.model.po;

import com.shiping.webstudy.registration.model.bo.UserBo;

/**
 * Created by shipin on 2015/7/11.
 */
public class UserPo {
    String username;
    String nickname;
    String password;
    String email;
    String sex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * convert this PO Object to the same BO Object
     * @return
     */
    public UserBo convertBo() {
        UserBo bo = new UserBo();
        bo.setUsername(username);
        bo.setPassword(password);
        bo.setNickname(nickname);
        bo.setEmail(email);
        bo.setSex(sex);
        return bo;
    }
}
