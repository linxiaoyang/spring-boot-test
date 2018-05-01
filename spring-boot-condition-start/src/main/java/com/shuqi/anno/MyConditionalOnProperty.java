package com.shuqi.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.shuqi.MyOnPropertyCondition;
import org.springframework.context.annotation.Conditional;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(MyOnPropertyCondition.class)
public @interface MyConditionalOnProperty {


    String value();


    String prefix() default "";


    String[] name() default {};


    String havingValue() default "";


    boolean matchIfMissing() default false;


    boolean relaxedNames() default true;


    //TODO ADD ONE PROPERTY
    String[] havingValues() default {};

}
