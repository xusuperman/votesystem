package com.cssl.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class choose {

    private int oid;
    private String content;
    private int osid;
    private int piao;
    private int itemnumber;
    private String baifenbi;
    private List<String> contentlist;

}
