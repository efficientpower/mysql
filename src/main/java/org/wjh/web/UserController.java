package org.wjh.web;

import java.util.Arrays;
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
            Integer[] ids = {4,3,2,1};
            List<User> userList = userService.getByIds(Arrays.asList(ids));
            res.setData(userList);
        }catch(Exception e){
            res.setCode(MobileCode.FAIL.getCode());
            res.setMesage(MobileCode.FAIL.getMessage());
        }
        return res;
    }
}
