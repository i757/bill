package com.paopao.bill.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luoxiaozhu
 * @date 2018-2-28-0028 17:24
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;

    @Column(name = "account")
    private String account;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
