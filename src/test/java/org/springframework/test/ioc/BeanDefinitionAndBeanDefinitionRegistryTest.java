package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

	@Test
	public void testBeanFactory() throws Exception {
		// 创建一个工厂类
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 定义BeanDefinition并注册
		BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
		beanFactory.registerBeanDefinition("helloService", beanDefinition);
		// 1. 去检查singletonMap里是否有该bean
		// 2. 如果有直接返回
		// 3.如果没有，通过beanDefinitionMap获取beanDefinition，通过beanDefinition的Class反射创建并加入到singletonMap
		HelloService helloService = (HelloService) beanFactory.getBean("helloService");
		helloService.sayHello();
	}
}
