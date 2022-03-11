package com.udemy.primeiroprojetospringbatch.reader;

import com.udemy.primeiroprojetospringbatch.dominio.Cliente;
import javax.sql.DataSource;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Configuration
public class JdbcCursorReaderConfig {

    @Bean
    public JdbcCursorItemReader<Cliente> jdbcCursorItemReader(@Qualifier("appDataSouce") DataSource dataSource) {
        return new JdbcCursorItemReaderBuilder<Cliente>()
            .name("jdbcCursorItemReader")
            .dataSource(dataSource)
            .sql("SELECT * FROM CLIENTE")
            .rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
            .build();
    }

}
