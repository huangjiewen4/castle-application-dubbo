package com.sample.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class DubboProviderConfigBean {

	@Value("${provider.app_name?:provider_mdm_test}")
	private String appName;

	@Value("${provider.registry_address?:zookeeper://120.76.217.241:2181}")
	private String registryAddress;

	@Value("${provider.protocol_port?:20883}")
	private Integer protocolPort;

	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setTimeout(1000000);
		providerConfig.setSerialization("kryo");
		return providerConfig;
	}

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig config = new ApplicationConfig(appName);
		return config;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setAddress(registryAddress);
		return config;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig config = new ProtocolConfig("dubbo", protocolPort);
		config.setSerialization("kryo");
		return config;
	}

	@Bean
	public static AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		return annotationBean;
	}

}
