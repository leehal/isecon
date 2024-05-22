package com.kh.isecon.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersVo {
    private int uno;
    private String id;
    private String pwd;
    private String phone;
    private String address;
    private char admin;
    private String nickname;
    private String uimg;
}
