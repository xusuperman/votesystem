package com.cssl.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subjectvo {

    private int sid;
    private String title;
    private int type;
    private int pageIndex=1;
    private int pageSize=3;

}
