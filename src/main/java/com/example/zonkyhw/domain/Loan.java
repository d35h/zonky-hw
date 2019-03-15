package com.example.zonkyhw.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class Loan {

    @NotNull
    private long id;
    private String name;
    private String nickName;
    private Date datePublished;

}
