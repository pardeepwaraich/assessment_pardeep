package com.pardeep.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.UUID;

@Configuration
@EnableElasticsearchRepositories(basePackages = "co.pardeep.repository")
public class ElasticsearchConfiguration {

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(getNodeClient());
    }

    private Client getNodeClient() {
        return NodeBuilder.nodeBuilder()
                .clusterName(UUID.randomUUID().toString())
                .local(true)
                .node()
                .client();
    }
}
