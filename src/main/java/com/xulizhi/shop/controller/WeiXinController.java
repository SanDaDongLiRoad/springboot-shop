package com.xulizhi.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10133
 */
@Slf4j
@RestController
@RequestMapping("weixin")
public class WeiXinController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        //获取code后，请求以下链接获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2c9123db004a728f&secret=7d8df054212596d59283a65e1aee3543&code="+code+"&grant_type=authorization_code";
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}", response);
        JSONObject responseJson = JSONObject.parseObject(response);

        //拉取用户信息(需scope为 snsapi_userinfo)
        url = "https://api.weixin.qq.com/sns/userinfo?access_token="+responseJson.getString("access_token")+"&openid="+responseJson.getString("openid")+"&lang=zh_CN";
        response = restTemplate.getForObject(url,String.class);
        log.info("response={}", response);
    }
}
