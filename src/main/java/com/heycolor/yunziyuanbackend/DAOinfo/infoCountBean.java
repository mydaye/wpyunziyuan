package com.heycolor.yunziyuanbackend.DAOinfo;

import java.util.Date;

public class infoCountBean {
    private final int k;

    private final int count;

    public infoCountBean(int k, int count) {
        this.k = k;
        this.count = count;
    }

    public int getK() {
        return k;
    }

    public int getCount() {
        return count;
    }
}
