package com.example.demo.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

/**
 * 如果不做配置的话，所有bean都会调用这个后置处理器
 */
@Repository
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println(bean.getClass());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
