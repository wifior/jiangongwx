package com.test.modular.qt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weixin4j.spring.web.WeixinJieruController;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/weixin/jieru")
public class JieruController extends WeixinJieruController {

    @Override
    public String getToken(HttpServletRequest httpServletRequest) {
        return "1234567890";
    }

}
