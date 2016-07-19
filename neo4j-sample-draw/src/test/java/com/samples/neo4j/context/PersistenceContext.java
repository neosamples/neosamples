package com.samples.neo4j.context;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.samples.neo4j.Application;

@Configuration
@EnableNeo4jRepositories("com.samples.neo4j.repository")
@EnableTransactionManagement
@ComponentScan(excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Application.class) }, basePackages = {
        "com.flavorwocky" })
@EnableAutoConfiguration
public class PersistenceContext extends Neo4jConfiguration {

  @Override
  public SessionFactory getSessionFactory() {
    return new SessionFactory("com.samples.neo4j.domain");
  }

  @Override
  @Bean
  public Session getSession() throws Exception {
    return super.getSession();
  }
}
