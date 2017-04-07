/**
 * 
 */
package com.controller;



import java.util.List;

import com.jfinal.core.Controller;
import com.model.User;

/**
 * @author blackagooes
 *
 */
public class UserController extends Controller {
	public void register(){
        render("register.jsp");
    }
    public void login(){
        render("login.jsp");
    }
    public void submit(){
        String name = getPara("username");
        String password = getPara("password");
       
        List users = User.dao.find("SELECT * FROM tbuser WHERE username = '"+name+"' AND password = '"+password+"'");
        setAttr("users", users);
        if(users.size() > 0){
            System.out.println("登录成功");
            render("index.html");
        }else{
            System.out.println("登录失败");
        }
        login();
    }
    public void add(){
        User user = getModel(User.class, "user");
        user.save();

        System.out.println("注册成功");
        login();
    }

}
