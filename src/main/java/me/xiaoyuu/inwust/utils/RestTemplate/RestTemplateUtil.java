package me.xiaoyuu.inwust.utils.RestTemplate;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestTemplateUtil {
    public static RestTemplate getInstance() {
        RestTemplate restTemplate = new RestTemplate();

        //设置RestTemplate的异常处理类
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());

        // restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        MappingJackson2HttpMessageConverter converter = new WxMappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
