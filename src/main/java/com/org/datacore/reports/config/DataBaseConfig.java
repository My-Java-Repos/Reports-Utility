package com.org.datacore.reports.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


@Configuration
public class DataBaseConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource firstDataSource() {

		return DataSourceBuilder.create().build();

	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("firstDataSource") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplateTwo(@Qualifier("secondDataSource") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
