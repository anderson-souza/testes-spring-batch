package com.udemy.primeiroprojetospringbatch.reader;

import java.util.Arrays;
import java.util.Iterator;
import org.springframework.batch.item.support.IteratorItemReader;

public class ParImparItemReader extends IteratorItemReader<Integer> {

    public ParImparItemReader(Iterator<Integer> iterator) {
        super(iterator);
    }

    public ParImparItemReader() {
        super(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).iterator());
    }

}
