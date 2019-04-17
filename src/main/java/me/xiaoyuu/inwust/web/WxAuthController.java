package me.xiaoyuu.inwust.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.xiaoyuu.inwust.core.Result;
import me.xiaoyuu.inwust.core.ResultGenerator;
import me.xiaoyuu.inwust.core.UserTokenManager;
import me.xiaoyuu.inwust.dto.LoginSuccessDTO;
import me.xiaoyuu.inwust.dto.UserToken;
import me.xiaoyuu.inwust.dto.WxLoginInfo;
import me.xiaoyuu.inwust.dto.WxUserInfo;
import me.xiaoyuu.inwust.model.User;
import me.xiaoyuu.inwust.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@Validated
public class WxAuthController {
    private final Log logger = LogFactory.getLog(WxAuthController.class);

    @Resource
    private UserService userService;
    @Autowired
    private WxMaService wxMaService;

    @PostMapping("login_by_wx")
    public Result loginByWx(@RequestBody WxLoginInfo loginInfo, HttpServletRequest request) {
        String code = loginInfo.getCode();
        WxUserInfo wxUserInfo = loginInfo.getWxUserInfo();
        if (code == null || wxUserInfo == null) {
            return ResultGenerator.genFailResult("参数有误");
        }

        String sessionKey = null;
        String openid = null;
        try {
            WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openid = result.getOpenid();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        if (sessionKey == null || openid == null) {
            return ResultGenerator.genFailResult("获取信息失败");
        }
        User user = userService.findBy("openid", openid);
        if (user == null) {
            user = new User();
            user.setAvatar(wxUserInfo.getAvatarUrl());
            user.setGender(wxUserInfo.getGender());
            user.setNickname(wxUserInfo.getNickName());
            user.setOpenid(openid);

            userService.save(user);
        }

        UserToken userToken = UserTokenManager.generateToken(user.getId());
        userToken.setSessionKey(sessionKey);
        LoginSuccessDTO successDTO = new LoginSuccessDTO();
        successDTO.setWxUserInfo(wxUserInfo);
        successDTO.setUserToken(userToken);
        return ResultGenerator.genSuccessResult(successDTO);

    }
}
