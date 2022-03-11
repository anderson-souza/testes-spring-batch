package com.udemy.primeiroprojetospringbatch.step;

import com.udemy.primeiroprojetospringbatch.StepLogListener;
import com.udemy.primeiroprojetospringbatch.reader.ParImparItemReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParImparStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step imprimirParImpar() {
        return stepBuilderFactory
            .get("imprimirParImpar")
            .<Integer, String>chunk(10) //Lê um inteiro e escreve uma String
            .reader(new ParImparItemReader())
            .processor(parOuImparProcessor())
            .listener(new StepLogListener())
            .writer(imprimeWritter())
            .build();
    }

    // Processa CADA item da lista e retorna o item processado
    private FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>(
            item -> item % 2 == 0 ? String.format("Item %s é par", item)
                : String.format("Item %s é impar", item));
    }

    // Escreve cada item processado
    private ItemWriter<String> imprimeWritter() {
        return itens -> itens.forEach(System.out::println);
    }

}
