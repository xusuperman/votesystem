package com.cssl.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class user {

    private int uid;
    private String username;
    private String password;
    private int isAdmin;
    private Set<item> items=new HashSet<>();

}
