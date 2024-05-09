package com.kh.isecon.VO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductVo {
    private int pno;
    private String pname;
    private int price;
    private String option;
    private String pimg;
}