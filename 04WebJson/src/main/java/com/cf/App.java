package com.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 使用fastjson解析
 *
 */
//@SpringBootApplication
//public class App extends WebMvcConfigurerAdapter {
//
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//		super.configureMessageConverters(converters);
//		// 1、需要先定义一个 convert 转换消息的对象;
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//		
//		//3、在convert中添加配置信息.
//		fastConverter.setFastJsonConfig(fastJsonConfig);
//		//4、将convert添加到converters当中.
//		converters.add(fastConverter);
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
//	}
//}


@SpringBootApplication
public class App {

	@Bean
	public HttpMessageConverters fastJsonConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}