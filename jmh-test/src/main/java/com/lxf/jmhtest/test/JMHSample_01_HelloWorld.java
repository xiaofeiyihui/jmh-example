package com.lxf.jmhtest.test;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Description:
 * @Auther: lxf
 * @Date: 2019/11/27 16:21
 */
public class JMHSample_01_HelloWorld {
    @GenerateMicroBenchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
        System.out.println("test");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + JMHSample_01_HelloWorld.class.getSimpleName() + ".*")
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
