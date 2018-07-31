package org.akj.springboot.inventory.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class HikariDatasourceConfig extends HikariConfig {

	@Bean
	public DataSource dataSource() throws SQLException {
		return new HikariDataSource(this);
	}

}