package com.test.modular.qt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.WeixinException;
import org.weixin4j.component.UserComponent;
import org.weixin4j.model.user.User;
import org.weixin4j.spring.WeixinTemplate;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WeixinTemplate weixinTemplate;

    @RequestMapping("/info")
    @ResponseBody
    public String getUserInfo() throws WeixinException {
        UserComponent userComponent = new UserComponent(weixinTemplate);
        User user = userComponent.info("oj9pd6XGLbaL3wWJohHcgCSsb_0w");
        return user.getHeadimgurl();
    }

    @RequestMapping("/index")
    public String index() throws WeixinException {
        return "index";
    }


}
