package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author derekyi
 * @date 2020/12/2
 */
public class FactoryBeanTest {

	@Test
	public void testFactoryBean() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

		// factory bean相当于一个代理
		// 容器在初始化时创建的是代理，后续获取是根据代理来获取
		// 如果代理是单例，则需要进行缓存，不是则每次获取时创建
		// 代理生成对象的过程也要区分单例，单例再从缓存中获取
		Car car = applicationContext.getBean("car", Car.class);
		assertThat(car.getBrand()).isEqualTo("porsche");
	}
}
