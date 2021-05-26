package com.carl.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;

    private String bookname;

    private String author;

    private Double price;

    private Integer classid;

    private String descr;

    private String path;

    private  String classifyName;// 单列处理



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", classid=" + classid +
                ", descr='" + descr + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}