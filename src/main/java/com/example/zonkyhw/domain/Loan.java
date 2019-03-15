package com.example.zonkyhw.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class Loan {

    private long id;
    private String name;
    private String nickName;
    private Date datePublished;

}
