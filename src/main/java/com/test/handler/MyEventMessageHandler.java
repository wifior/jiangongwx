package com.test.handler;

import org.springframework.stereotype.Component;
import org.weixin4j.model.message.OutputMessage;
import org.weixin4j.model.message.event.*;
import org.weixin4j.model.message.output.TextOutputMessage;
import org.weixin4j.spi.IEventMessageHandler;

import java.time.LocalDateTime;

@Component
public class MyEventMessageHandler implements IEventMessageHandler {
    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        LocalDateTime today = LocalDateTime.now();
        out.setContent("感谢您的关注！"+today.toString());
        return out;
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        //取消关注
        return null;
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("感谢您的关注！，请回复您的姓名完成登记");
        return out;
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("请回复您的姓名完成登记！");
        return out;
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("点击了菜单！");
        return out;
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("点击了链接！");
        return out;
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("扫码！");
        return out;
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("扫码等待中！");
        return out;
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("发起拍照！");
        return out;
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("选择相册！");
        return out;
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("上次图片！");
        return out;
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("选择地理位置！");
        return out;
    }
}
