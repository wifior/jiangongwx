package com.test.handler;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.test.modular.wx.entity.Wxlogin;
import com.test.modular.wx.service.WxloginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.normal.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.model.user.User;
import org.weixin4j.spi.INormalMessageHandler;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Log4j2
public class MyNormalMessageHandler implements INormalMessageHandler {

    @Autowired
    private WxloginService wxloginService;

    @Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
        log.debug("文本消息：" + msg.getContent());

        TextOutputMessage out = new TextOutputMessage();
        if(StrUtil.isNotBlank(StrUtil.trim(msg.getContent()))){
            if(Validator.isChinese(msg.getContent())){

                String openid = msg.getFromUserName();
                Wxlogin wx = wxloginService.getUserByOpenId(openid,new Date());
                if(wx!=null){
                    out.setContent( "您今天已经登记了，我现在是复读机，你说的是："+msg.getContent());
                }else {
                    out.setContent( msg.getContent()+",您好，您与"+ DateUtil.now()+"登记成功！");
                    User user = wxloginService.getUserInfo(msg.getFromUserName());
                    Wxlogin wxlogin = new Wxlogin();
                    wxlogin.setOpenid(openid);
                    wxlogin.setHeadimgurl(user.getHeadimgurl());
                    wxlogin.setNickname(user.getNickname());
                    wxlogin.setName(msg.getContent());
                    wxlogin.setRemark(JSONUtil.parse(user).toString());
                    wxlogin.setCreateTime(LocalDateTime.now());
                    wxloginService.save(wxlogin);
                }
            }else {
                out.setContent( "您确定是"+msg.getContent()+"?" );
            }
        }

        return out;
    }

    @Override
    public OutputMessage imageTypeMsg(ImageInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage videoTypeMsg(VideoInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage locationTypeMsg(LocationInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage linkTypeMsg(LinkInputMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }
}
