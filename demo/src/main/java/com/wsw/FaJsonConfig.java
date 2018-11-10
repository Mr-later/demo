package com.wsw;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
@Configuration
public class FaJsonConfig extends WebMvcConfigurerAdapter {
    public void configureMessageConverters(List converters) {
        super.configureMessageConverters(converters);//
        FastJsonHttpMessageConverter fastConstructor=new FastJsonHttpMessageConverter();//1
        FastJsonConfig fastJsonConfig=new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);//2
        fastConstructor.setFastJsonConfig(fastJsonConfig);//3
        converters.add(fastConstructor);//4
    }
}
