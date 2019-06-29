package com.cssl.vo;

import com.cssl.pojo.choose;
import com.cssl.pojo.user;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class itemvo {
    private int iid;
    private int uid;
    private int sid;
    private int oid;
    private choose oo;
    private int itemnumber;
    private List<Integer> oidarray;
}
