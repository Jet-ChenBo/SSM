package com.chen.controller;

import com.chen.pojo.Books;
import com.chen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier(value = "bookServiceImpl")
    private BookService bookService;

    // 查询全部书籍
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("books", books);
        return "allBook";
    }

    // 增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPapper(){
        return "addBook";
    }

    // 添加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    // 修改书籍页面
    @RequestMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("books", books);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        if (bookService.updateBook(books) > 0) System.out.println("修改成功");
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }
}
