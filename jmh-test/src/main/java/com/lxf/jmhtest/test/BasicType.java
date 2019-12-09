package com.lxf.jmhtest.test;



import com.lxf.jmhtest.model.User;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Auther: lxf
 * @Date: 2019/11/27 14:42
 */

@BenchmarkMode(Mode.AverageTime) // 测试方法平均执行时间
@OutputTimeUnit(TimeUnit.MICROSECONDS) // 输出结果的时间粒度为微秒
@State(Scope.Thread) // 每个测试线程一个实例
public class BasicType {

    @GenerateMicroBenchmark
    public int intFinalSum() {
        final int a=34;
        final int b=30;
        return a+b;
    }

    @GenerateMicroBenchmark
    public int intSum() {
        int a=34;
        int b=30;
        return a+b;
    }

    @GenerateMicroBenchmark
    public User getFinalUser() {
        final User user = new User();
        user.setAge(12);
        user.setName("测试");
        user.setId(new Random().nextInt());
        return user;
    }
    @GenerateMicroBenchmark
    public User getUser() {
        User user = new User();
        user.setAge(12);
        user.setName("测试");
        user.setId(new Random().nextInt());
        return user;
    }



    public static void main(String[] args)throws Exception {
        // 使用一个单独进程执行测试，执行5遍warmup，然后执行5遍测试
        Options opt = new OptionsBuilder()
                .include(".*" +BasicType.class.getSimpleName()+ ".*")
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(10)
                .build();
        new Runner(opt).run();
    }


}
