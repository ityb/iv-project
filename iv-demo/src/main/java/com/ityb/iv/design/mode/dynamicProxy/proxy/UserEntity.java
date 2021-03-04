package com.ityb.iv.design.mode.dynamicProxy.proxy;

/**
 * Created by viruser on 2020/4/14.
 */
public class UserEntity {

    private Long id;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
