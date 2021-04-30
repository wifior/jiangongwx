package com.test.modular.qt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.WeixinException;
import org.weixin4j.component.QrcodeComponent;
import org.weixin4j.model.js.Ticket;
import org.weixin4j.model.qrcode.Qrcode;
import org.weixin4j.model.qrcode.QrcodeType;
import org.weixin4j.spring.WeixinTemplate;

@Controller
@RequestMapping("/qrcode")
public class TicketController {

    @Autowired
    private WeixinTemplate weixinTemplate;


    @RequestMapping("/scan")
    @ResponseBody
    public String scan() throws WeixinException {
        Ticket ticket = weixinTemplate.getJsApiTicket();
        QrcodeComponent qrcodeComponent = new QrcodeComponent(weixinTemplate);
        Qrcode qrcode = qrcodeComponent.create(QrcodeType.QR_SCENE,1,60);
        return qrcodeComponent.showQrcode(qrcode.getTicket());
    }

}
