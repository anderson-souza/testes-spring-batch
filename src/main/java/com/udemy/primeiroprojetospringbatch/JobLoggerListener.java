package com.udemy.primeiroprojetospringbatch;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

@Log4j2
public class JobLoggerListener {

    private static String START_MESSAGE = "JOB %s INICIOU A EXECUÇÃO";
    private static String END_MESSAGE = "JOB %s FINALIZOU A EXECUÇÃO COM O STATUS %s";

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        log.info(String.format(START_MESSAGE, jobExecution.getJobInstance().getJobName()));
    }
    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        log.info(
            String.format(END_MESSAGE,
                jobExecution.getJobInstance().getJobName(),
                jobExecution.getStatus()));
    }

}
