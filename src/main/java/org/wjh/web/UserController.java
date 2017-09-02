package org.wjh.web;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
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
            for(User u : userList){
                String passwd = u.getId() +"";
                String salt = DigestUtils.md5Hex(u.getSalt());
                u.setPassword(DigestUtils.md5Hex(passwd + salt));
                u.setName("hello-" + u.getId());
                u.setDbUpdateTime(new Date());
            }
            userService.batchUpdate(userList);
            res.setData(userList);
        }catch(Exception e){
            res.setCode(MobileCode.FAIL.getCode());
            res.setMesage(MobileCode.FAIL.getMessage());
        }
        return res;
    }
}
