package com.wsw.spring_demo_1;

import com.wsw.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private   final  MyProperties1 myProperties;
    private   final  MyProperties2 myProperties2;
    private JdbcTemplate jdbcTemplate;
    public Controller(MyProperties1 myProperties, MyProperties2 myProperties2, JdbcTemplate jdbcTemplate){
        this.myProperties=myProperties;
        this.myProperties2=myProperties2;
        this.jdbcTemplate=jdbcTemplate;
    }

    /**
     * 配置文件中的数据得到的实体类myProperties，ConfigurationProperties
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
   System.out.println("进入到hello方法");
        return  "myProperties:"+myProperties+"  myProperties2="+myProperties2;
    }

    /**
     * thymeleaf和ModelAndView的结合使用
     * @return
     */
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


     @RequestMapping("/getAllUser")
     public   List<User> getAllUser(){
        String sql ="SELECT * from t_user;";
        return   jdbcTemplate.queryForList(sql, null, User.class);
     }

     @RequestMapping("/getUserById")
     public User getUserById(@PathVariable  Long Id){
         String sql ="SELECT * from t_user where id =? ";
         return  jdbcTemplate.queryForList(sql, new Object[]{Id}, User.class).get(0);
     }
     @RequestMapping("/deleteUserById")
     public  List<User> deleteUserById(Long Id){
         String sql ="delete from t_user where id =? ";
         jdbcTemplate.update(sql,Id);
         return   jdbcTemplate.queryForList(sql, null, User.class);
     }

     @RequestMapping("/addUser")
     public  List<User> addUser(User user){
        System.out.println("addUser-------");
         String sql = "insert into t_user(username, password) values(?, ?)";
          jdbcTemplate.update(sql,new Object[]{user.getUsername(), user.getPassword()});
         return   jdbcTemplate.query("SELECT * from t_user ;",
                 new Object[]{}, new BeanPropertyRowMapper<>(User.class));
     }

     @RequestMapping("/{id}")
     public List<User> editUser(@PathVariable long id ,@RequestBody User user ){
         // 根据主键ID修改用户信息
         System.out.println(id);
         System.out.println( user.getUsername());
         System.out.println(user.getPassword());
         String sql = "UPDATE t_user SET username = ? ,password = ? WHERE id = ?";
          jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), id);
         return   jdbcTemplate.queryForList("SELECT * from t_user where id=?;",
                 new Object[]{id}, User.class);

     }
}
