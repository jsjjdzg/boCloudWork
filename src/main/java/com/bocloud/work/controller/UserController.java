
package com.bocloud.work.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bocloud.work.entity.User;
import com.bocloud.work.service.IUserService;



@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@RequestMapping("/test")
	@ResponseBody
	public User test() {
		User u = iUserService.selectById(1);
		return u;
	}	
	
	  /**  
     * 获取所有用户列表  
     * @param request  
     */  
    @RequestMapping("/getAllUser")  

    public String getAllUser(HttpServletRequest request,Model model){  
    	 List<User> user = iUserService.findAll(); 
        model.addAttribute("userList", user);  
        request.setAttribute("userList", user);  
     System.out.println("111");
        return "/allUser";  
    }
    /**  
     * 跳转到添加用户界面  
     * @param request  
     * @return  
     */  
    @RequestMapping("/AddUser")  
    public String toAddUser(){  
        return "/addUser";  
    }  
    /**  
     * 添加用户并重定向  
     * @param user  
     * @param request  
     * @return 
     * @return 
     */  
   
    @RequestMapping("/addUser")
    public  String addUser(User user,Model model){  
    	iUserService.save(user);  
   return "allUser.html";
    }  
    /**  
     *编辑用户  
     * @param user  
     * @param request  
     * @return  
     */  
    @RequestMapping("/updateUser")  
    public String updateUser(User user,HttpServletRequest request,Model model){  
        if(iUserService.update(user)){  
            user = iUserService.findById(user.getId());  
            model.addAttribute("user", user);  
            return "redirect:/user/getAllUser";  
        }else{  
            return "/error";  
        }  
    }  
    /**  
     * 根据id查询单个用户  
     * @param id  
     * @param request  
     * @return  
     */  
    @RequestMapping("/getUser")  
    public String getUser(int id,HttpServletRequest request,Model model){  
        request.setAttribute("user", iUserService.findById(id));  
        model.addAttribute("user", iUserService.findById(id));  
        return "/editUser";  
    }  
    /**  
     * 删除用户  
     * @param id  
     * @param request  
     * @param response  
     */  
    @RequestMapping("/delUser")  
    public void delUser(int id,HttpServletRequest request,HttpServletResponse response){  
        String result = "{\"result\":\"error\"}";  
        if(iUserService.delete(id)){  
            result = "{\"result\":\"success\"}";  
        }  
        response.setContentType("application/json");  
        try {  
            PrintWriter out = response.getWriter();  
            out.write(result);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
   
    public String ajaxValidateLoginname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
		String username = req.getParameter("username");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = IUserService.ajaxValidateusername(username);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}
}
