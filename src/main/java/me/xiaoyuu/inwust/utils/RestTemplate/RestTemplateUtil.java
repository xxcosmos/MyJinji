package me.xiaoyuu.inwust.utils.RestTemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class RestTemplateUtil {
    public static RestTemplate getInstance() throws KeyManagementException, NoSuchAlgorithmException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        SSLValidation.turnOffSSLChecking();
        //设置RestTemplate的异常处理类
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());

        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

}
