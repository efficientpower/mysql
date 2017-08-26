package org.wjh.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjh.common.AjaxResult;
import org.wjh.common.MobileCode;
import org.wjh.domain.User;
import org.wjh.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser.do")
    @ResponseBody
    public AjaxResult<Object> getUser(String userId) {
        AjaxResult<Object> res = new AjaxResult<Object>();
        try{
            User user = userService.getByUserId(userId);
            userService.updateInTrans(userId);
            List<User> userList = userService.list("id desc ", 0, 3);
            res.setData(userList);
        }catch(Exception e){
            res.setCode(MobileCode.FAIL.getCode());
            res.setMesage(MobileCode.FAIL.getMessage());
        }
        return res;
    }
}
