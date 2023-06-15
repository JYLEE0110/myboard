package com.example.myBoard.dto;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    // tbl_board 
    private Long tno;
    private String title;
    private String content;
    private String writer;
    private Date registDate;
    private Date modifyDate;
}
