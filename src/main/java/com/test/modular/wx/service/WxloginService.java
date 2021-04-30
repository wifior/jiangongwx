package com.test.modular.wx.service;

import com.test.modular.wx.entity.Wxlogin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.weixin4j.model.user.User;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ghjun
 * @since 2021-04-30
 */
public interface WxloginService extends IService<Wxlogin> {

    public User getUserInfo(String openid);

    Wxlogin getUserByOpenId(String openid, Date date);
}
