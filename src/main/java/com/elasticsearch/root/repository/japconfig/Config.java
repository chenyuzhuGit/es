package com.elasticsearch.root.repository.japconfig;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com/elasticsearch/root/repository/repositories")
public class Config {
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		// 安装x-pack后的初始化方法
		Settings settings = Settings.builder()
	            .put("client.transport.nodes_sampler_interval", "5s")
	            .put("client.transport.sniff", false)
	            .put("transport.tcp.compress", true)
	            .put("cluster.name", "cluster-id")
	            .put("xpack.security.transport.ssl.enabled", true)
	            .put("request.headers.X-Found-Cluster", "cluster-id")
	            .put("xpack.security.user", "user:password")
	            .put("xpack.security.transport.ssl.verification_mode", "none")
	            .build();
		// 使用的实现类与前面不同
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
		try {
			client.addTransportAddress(new TransportAddress(InetAddress.getByName("els.xinanli.com"), 9200));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ElasticsearchTemplate(client);
	}

}