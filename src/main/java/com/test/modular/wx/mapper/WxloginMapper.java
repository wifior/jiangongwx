package com.test.modular.wx.mapper;

import com.test.modular.wx.entity.Wxlogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.weixin4j.model.user.User;

import java.util.Date;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ghjun
 * @since 2021-04-30
 */
public interface WxloginMapper extends BaseMapper<Wxlogin> {

    Wxlogin getUserByOpenId(@Param("openid") String openid, @Param("startTime") String startTime, @Param("endTime") String endTime);
}
