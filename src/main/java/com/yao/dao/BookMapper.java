package com.yao.dao;

import com.yao.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //add
    int addBook(Books books);

    //delete
    int deleteBookById(@Param("bookId") int id);

    //update
    int updateBook(Books books);

    //query
    Books queryBookById(@Param("bookId") int id);

    //queryAll
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName")String bookName);
}
