package com.wsw.spring_demo_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private   final  MyProperties1 myProperties;
    private   final  MyProperties2 myProperties2;
    public Controller( MyProperties1 myProperties,MyProperties2 myProperties2){
        this.myProperties=myProperties;
        this.myProperties2=myProperties2;
    }
    @RequestMapping("/hello")
    public String hello(){
   System.out.println("进入到hello方法");
        return  "myProperties:"+myProperties+"  myProperties2="+myProperties2;
    }

    @RequestMapping("/index")
     public ModelAndView index(){
         ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
         view.setViewName("index");
         view.addObject("title","王世伟的web页面");
         view.addObject("desc","小骚货");
         Author author = new Author();
         author.setAge(55);
         author.setEmail("m17070063919@163.com");
         author.setName("王世伟");
         view.addObject("author",author);
         return view;
     }

     @GetMapping("/index2")
     public  String index2(HttpServletRequest request){
        request.setAttribute("title","王世伟的第二个web 页面");
        request.setAttribute("desc","简单描述");
         Author author = new Author();
         author.setAge(555);
         author.setEmail("17070063919@163.com");
         author.setName("王世伟2");
        request.setAttribute("author",author);
        return "index";
     }


     class Author{
        Integer age ;
        String name;
        String email;

         public Integer getAge() {
             return age;
         }

         public void setAge(Integer age) {
             this.age = age;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String getEmail() {
             return email;
         }

         public void setEmail(String email) {
             this.email = email;
         }
     }

}
