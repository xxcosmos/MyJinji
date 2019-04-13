package me.xiaoyuu.inwust.utils.RestTemplate;

import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {
    public static RestTemplate getInstance() {
        RestTemplate restTemplate = new RestTemplate();
        //设置RestTemplate的异常处理类
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
