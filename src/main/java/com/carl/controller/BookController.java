package com.carl.controller;
import com.carl.pojo.Book;
import com.carl.pojo.Classify;
import com.carl.pojo.QueryVO;
import com.carl.service.BookService;
import com.carl.service.ClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ClassifyService classifyService;
//分页查询
@RequestMapping("findAll")
public String findAll(@RequestParam(value="pageNum",required = false,defaultValue = "1") Integer pageNum,
                      @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize
 , QueryVO queryVO,// 多条件查询
       Model model){
    //  准备数据
    PageHelper.startPage(pageNum,pageSize);
    List<Book> bookList = bookService.findAll(queryVO);
    PageInfo<Book> pageInfo = new PageInfo<Book>(bookList);
    //  创建ModelAndView 对象

    // 添加数据
    model.addAttribute("pageInfo",pageInfo);//书籍信息
    List<Classify> classifyList = classifyService.findAll();
    model.addAttribute("classifyList",classifyList); //类别
    model.addAttribute("queryVO",queryVO);// 查询条件  回显

    // 指定页面
    return "bookList";
}











@RequestMapping("toaddBookView")
public String addBookview(Model model){
    List<Classify> classifyList = classifyService.findAll();

     model.addAttribute("classifyList",classifyList);

    return  "addBookView";
}

@RequestMapping("addBook")
public String addBook(@RequestParam()MultipartFile photo, Book book)  {

    String path="D:\\apache-tomcat-8.5.40\\webapps\\upload\\";

    String fileName =photo.getOriginalFilename();
    if(fileName != null && fileName != ""){
       fileName= UUID.randomUUID().toString().replace("-","")+fileName;
        try {
            photo.transferTo(new File(path,fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        book.setPath(fileName);

    }
    bookService.addBook(book);


    return "redirect:findAll";
}
    @RequestMapping("toupdateBookView")
    public String toupdateBookView(Integer id,Model model){
        List<Classify> classifyList = classifyService.findAll();




        model.addAttribute("classifyList",classifyList);


       Book book= bookService.findById(id);

       model.addAttribute("book",book);

        return  "updateBookView";
    }
    @RequestMapping( value = "updateBook",method = RequestMethod.POST)
    public String updateBook(@RequestParam()MultipartFile photo, Book book)  {

        String path="D:\\apache-tomcat-8.5.40\\webapps\\upload\\";

        String fileName =photo.getOriginalFilename();
        if(fileName != null && fileName != ""){
            fileName= UUID.randomUUID().toString().replace("-","")+fileName;
            try {
                photo.transferTo(new File(path,fileName));
                if(book.getPath()!=null){
                    new File(path,book.getPath()).delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            book.setPath(fileName);

        }
        bookService.updatebook(book);


        return "redirect:findAll";
    }
//    @RequestMapping("deleteBook")
//    public String deleteBook(Integer id){
//
//        bookService.delBook(id);
//
//        return "redirect:findAll";
//    }

    @RequestMapping("delAllIds")
    public String delAllIds(Integer[] id){

        bookService.delBook(id);

        return "redirect:findAll";
    }



}
