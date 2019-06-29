package com.cssl.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class chooseVo {

    private int oid;
    private String content;
    private String newoidcontent;
    private int osid;
    private int piao;
    private int itemnumber;
    private String baifenbi;
    private List<String> contentlist=new ArrayList<>();
}
