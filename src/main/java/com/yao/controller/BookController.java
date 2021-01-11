package com.yao.controller;

import com.yao.pojo.Books;
import com.yao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Controller 调service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService ;

    //查询全部书籍，返回书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> booksList = bookService.queryAllBook();
        model.addAttribute("list",booksList);
        return "allBook";
    }

    //add 跳转到添加页面
    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    //add 请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("add a book"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";  //重定向到allBook的请求
    }


    //to update
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }

    //update
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("update a book"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //query
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> queryBook = new ArrayList<Books>();
        queryBook.add(books);
        if(books==null){
            queryBook = bookService.queryAllBook();
            model.addAttribute("error","查询书籍不存在");
        }

        model.addAttribute("list",queryBook);
        return "allBook";
    }



    //delete
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
