package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class item {

    private int iid;
    private int uid;
    private int sid;
    private int oid;
    private choose oo;
    private int itemnumber;
    private List<Integer> oidarray;
}
