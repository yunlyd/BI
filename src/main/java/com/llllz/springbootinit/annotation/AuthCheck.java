package com.llllz.springbootinit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 权限校验
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 必须有某个角色
     *
     * @return
     */
    String mustRole() default "";

}
/*
这段代码定义了一个名为mustRole的成员变量，其类型为String，
表示必须有某个角色。当使用这个注解修饰一个方法时，可以通过mustRole()方法获取该方法的角色要求。

如果没有指定该成员变量，则默认为空字符串，即表示没有角色要求。因此，在方法调用时，需要判断mustRole()方法的返回值是否为空字符串，
如果为空，则说明没有角色要求，可以进行调用；如果不为空，则说明有角色要求，需要进行权限检查。
 */
