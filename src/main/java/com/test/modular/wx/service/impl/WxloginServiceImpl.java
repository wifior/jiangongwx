package com.test.modular.wx.service.impl;

import cn.hutool.core.date.DateUtil;
import com.test.modular.wx.entity.Wxlogin;
import com.test.modular.wx.mapper.WxloginMapper;
import com.test.modular.wx.service.WxloginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weixin4j.WeixinException;
import org.weixin4j.component.UserComponent;
import org.weixin4j.model.user.User;
import org.weixin4j.spring.WeixinTemplate;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ghjun
 * @since 2021-04-30
 */
@Service
public class WxloginServiceImpl extends ServiceImpl<WxloginMapper, Wxlogin> implements WxloginService {

    @Autowired
    private WxloginMapper wxloginMapper;

    @Autowired
    private WeixinTemplate weixinTemplate;

    @Override
    public User getUserInfo(String openid) {
        UserComponent userComponent = new UserComponent(weixinTemplate);
        User user = null;
        try {
            user = userComponent.info(openid);
            return user;
        } catch (WeixinException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Wxlogin getUserByOpenId(String openid, Date date) {
        String start = DateUtil.formatDate(date);
        String startTime = start+" 00:00:00";
        String endTime = start+" 23:59:59";
        Wxlogin wxlogin = wxloginMapper.getUserByOpenId(openid,startTime,endTime);
        return wxlogin;
    }
}
