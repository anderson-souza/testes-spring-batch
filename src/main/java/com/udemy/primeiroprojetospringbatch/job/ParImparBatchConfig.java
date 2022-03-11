package com.udemy.primeiroprojetospringbatch.job;

import com.udemy.primeiroprojetospringbatch.JobLoggerListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ParImparBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job imprimeParImpar(Step imprimirParImpar) {
        return jobBuilderFactory
            .get("imprimeParImpar")
            .start(imprimirParImpar)
            .incrementer(new RunIdIncrementer())
            .listener(JobListenerFactoryBean.getListener(new JobLoggerListener()))
            .build();

        // new RunIdIncrementer() Adiciona automaticamente um parâmetro para executar o job mais de uma vez.
        // Deve ser utilizado quando se sabe que o Job não precisa ser reinicializado de onde parou
    }



}
