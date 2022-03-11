package com.udemy.primeiroprojetospringbatch;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

@Log4j2
public class StepLogListener {

    private static String START_MESSAGE = "STEP %s INICIOU A EXECUÇÃO";
    private static String END_MESSAGE = "STEP %s FINALIZOU A EXECUÇÃO COM O STATUS %s";

    @BeforeStep
    public void beforeJob(StepExecution stepExecution) {
        log.info(String.format(START_MESSAGE, stepExecution.getStepName()));
    }

    @AfterStep
    public void afterJob(StepExecution stepExecution) {
        log.info(
            String.format(END_MESSAGE,
                stepExecution.getStepName(),
                stepExecution.getExitStatus()));
    }

}
