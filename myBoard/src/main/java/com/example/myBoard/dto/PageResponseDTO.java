package com.example.myBoard.dto;

import java.util.List;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// GenericType 
@Getter
@Setter
@ToString
public class PageResponseDTO<E> {

    private List<E> list;
    private int total; 

    @Builder(builderMethodName =  "withAll")
    public PageResponseDTO(List<E> list, int total) {
        this.list = list;
        this.total = total;
    }
    
}
