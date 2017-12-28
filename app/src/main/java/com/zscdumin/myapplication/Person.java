package com.zscdumin.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by ZSCDumin on 2017/12/28.
 * 作者邮箱：2712220318@qq.com
 */

public class Person extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
