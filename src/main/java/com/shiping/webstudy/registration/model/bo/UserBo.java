package com.shiping.webstudy.registration.model.bo;

import com.shiping.webstudy.registration.model.po.UserPo;

/**
 * Created by shipin on 2015/7/11.
 */
public class UserBo {

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

    public UserPo convertPo() {
        UserPo po = new UserPo();
        po.setUsername(this.username);
        po.setNickname(this.nickname);
        po.setPassword(this.password);
        po.setEmail(this.email);
        po.setSex(this.sex);
        return po;
    }
}

