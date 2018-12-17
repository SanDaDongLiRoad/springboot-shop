package com.xulizhi.shop.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 10133
 */
@Slf4j
@RestController
@RequestMapping("weixin")
public class WeiXinController {

    @GetMapping("auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        //通过code换取网页授权access_token url
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2c9123db004a728f&secret=7d8df054212596d59283a65e1aee3543&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject responseJson = JSONObject.parseObject(response);
        log.info("response={}", response);
        //拉取用户信息(需scope为 snsapi_userinfo) url
        url = "https://api.weixin.qq.com/sns/userinfo?access_token="+responseJson.getString("access_token")+"&openid="+responseJson.getString("openid")+"&lang=zh_CN";
        response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
