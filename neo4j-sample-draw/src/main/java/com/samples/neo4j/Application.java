package com.samples.neo4j;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.samples.neo4j")
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableNeo4jRepositories("com.samples.neo4j.repository")
public class Application extends Neo4jConfiguration {

  final String grapheneUrl;

  public Application() {
    // grapheneUrl = System.getenv("GRAPHENEDB_URL");
    grapheneUrl = "http://neo4j:neopass@localhost:7474";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public org.neo4j.ogm.config.Configuration getConfiguration() {
    org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
    config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver").setURI(grapheneUrl);
    return config;
  }

  @Override
  @Bean
  public SessionFactory getSessionFactory() {
    return new SessionFactory(getConfiguration(), "com.samples.neo4j.domain");
  }

  @Override
  @Bean
  @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
  public Session getSession() throws Exception {
    return super.getSession();
  }
}
