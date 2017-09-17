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
            List<User> userList = userService.list(" id ", 0, 3000);
            userService.updateInTrans(userList.get(0).getUserId());
            res.setData(userList);
        }catch(Exception e){
            res.setCode(MobileCode.FAIL.getCode());
            res.setMesage(MobileCode.FAIL.getMessage());
        }
        return res;
    }
}
