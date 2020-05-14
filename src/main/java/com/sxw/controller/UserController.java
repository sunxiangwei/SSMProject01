package com.sxw.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxw.domain.User;
import com.sxw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sunxiangwei on 2020-5-1.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService service;


    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/login.do")
    @ResponseBody
    public String login(String uname,String upass){
        System.out.println(uname+","+upass);
        boolean login = service.login(uname, upass);
        System.out.println(login);
        if(login){
            return "success";
        }
        return "error";
    }

    //查询全部用户
    @RequestMapping("/findById.do")
    public String findById(Integer id, Model model){
        User user = service.findById(1);
        System.out.println(user);
        model.addAttribute("user",user);
        return "findById";
    }

    //批量插入数据
    @RequestMapping("/insertUsers.do")
    public String insertUsers(Model model){
        List<User> userList = new ArrayList<User>();
        for(int i=0;i<100;i++){
            User user = new User();
            user.setUname(UUID.randomUUID().toString().substring(0,5));
            user.setUpass(UUID.randomUUID().toString().substring(0,5));
            userList.add(user);
        }
        service.insertUsers(userList);
        return "findById";
    }


    //分页
    @RequestMapping("/findAll.do")
    public String findAll(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, Model model){
        //从第几页开始，内页多少条记录
        PageHelper.startPage(pageNum,7);
        //从数据库查询的所有数据
        List<User> users = service.findAll();

        //我们可以将查询的结果使用：将查询的结果放在pageinfo中，这个pageinfo就有非常多能够用的
        //PageInfo<User> userPageInfo = new PageInfo<>(users);
        //第二个参数是 传入连续要显示的页码
        PageInfo<User> userPageInfo = new PageInfo<>(users,7);

        System.out.println("当前页面:"+userPageInfo.getPageNum());
        System.out.println("总页码:"+userPageInfo.getPages());
        System.out.println("总记录数:"+userPageInfo.getTotal());
        System.out.println("当前页有几条记录:"+userPageInfo.getSize());
        System.out.println("当前页的pageSize:"+userPageInfo.getPageSize());
        System.out.println("前一页:"+userPageInfo.getPrePage());
        System.out.println("结果:"+userPageInfo.getList());//查询结果

        //要连续显示的页码
        int[] navigatepageNums = userPageInfo.getNavigatepageNums();
        //存入数据到model
        model.addAttribute("userPageInfo",userPageInfo);
        return "findAll";
    }
}
