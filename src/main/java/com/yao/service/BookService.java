package com.yao.service;

import com.yao.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //add
    int addBook(Books books);

    //delete
    int deleteBookById(int id);

    //update
    int updateBook(Books books);

    //query
    Books queryBookById(int id);

    //queryAll
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName")String bookName);

}
