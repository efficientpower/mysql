package org.wjh.mysql.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjh.mysql.common.AjaxResult;
import org.wjh.mysql.common.MobileCode;
import org.wjh.mysql.domain.User;
import org.wjh.mysql.service.UserService;

@Controller
public class UserController{

    Log log = LogFactory.getLog(UserController.class);
    
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser.do")
    @ResponseBody
    public AjaxResult<Object> getUser(String userId) {
        AjaxResult<Object> res = new AjaxResult<Object>();
        try {
            List<User> userList = userService.list(" id ", 0, 10);
            userService.updateInTrans(userList.get(0).getUserId());
            res.setData(userList);
        } catch (Exception e) {
            log.error("getUser failed! ", e);
            res.setCode(MobileCode.FAIL.getCode());
            res.setMesage(MobileCode.FAIL.getMessage());
        }
        return res;
    }
}
