package com.llllz.springbootinit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 主类（项目启动入口）
 * @EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)解决同类方法调用时异步和事务不生效：
 *
 * 我们在开启springboot启动类上添加@EnableAsync，从而启动异步注解@Async
 *
 * 启动之后，我们可以在需要异步执行的方法上面添加@Async注解，即可实现异步，但是有一点，
 * 如果我们需要用同一个类中的方法调用另一个加了@Async注解的方法，这时@Async不起作用，
 * 原因和事务注解@Transactional失效的原因一样，没有用到代理类导致，
 * 这时我们可以通过在启动类添加@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)来解决问题。
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.llllz.springbootinit.mapper")
@EnableScheduling  //开启定时任务  例如：@Scheduled(fixedRate = 60 * 1000)每分钟执行一次
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
