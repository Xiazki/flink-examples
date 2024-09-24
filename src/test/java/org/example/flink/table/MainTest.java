package org.example.flink.table;

import junit.framework.TestCase;
import org.junit.Test;

public class MainTest extends TestCase {

    @Test
    public void test(){
        Main.main(null);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("done!");
    }

}