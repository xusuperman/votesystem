package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Subject {

    private int sid;
    private String title;
    private int type;
    private int totalitems;
    private int totalchoose;
}
