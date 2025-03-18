package com.heycolor.yunziyuanbackend.DAOinfo;

import java.util.Date;

public class addBean {
    private final String data_title;
    private final String data_img_list;
    private final String data_img_mx;
    private final String data_url;
    private final boolean data_good;
    private final String data_dir;
    private final String data_type;
    private final String data_country;
    private final String data_year;
    private final String data_note;
    private final int count_people;
    private final int count_score;
    private final Date gmt_create;

    public addBean(String data_title, String data_img_list, String data_img_mx, String data_url, boolean data_good, String data_dir, String data_type, String data_country, String data_year, String data_note, int count_people, int count_score, Date gmt_create) {
        this.data_title = data_title;
        this.data_img_list = data_img_list;
        this.data_img_mx = data_img_mx;
        this.data_url = data_url;
        this.data_good = data_good;
        this.data_dir = data_dir;
        this.data_type = data_type;
        this.data_country = data_country;
        this.data_year = data_year;
        this.data_note = data_note;
        this.count_people = count_people;
        this.count_score = count_score;
        this.gmt_create = gmt_create;
    }

    public String getData_title() {
        return data_title;
    }

    public String getData_img_list() {
        return data_img_list;
    }

    public String getData_img_mx() {
        return data_img_mx;
    }

    public String getData_url() {
        return data_url;
    }

    public boolean isData_good() {
        return data_good;
    }

    public String getData_dir() {
        return data_dir;
    }

    public String getData_type() {
        return data_type;
    }

    public String getData_country() {
        return data_country;
    }

    public String getData_year() {
        return data_year;
    }

    public String getData_note() {
        return data_note;
    }

    public int getCount_people() {
        return count_people;
    }

    public int getCount_score() {
        return count_score;
    }

    public Date getGmt_create() {
        return gmt_create;
    }
}
