package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.common.event.CustomEvent;

import java.util.concurrent.TimeUnit;

/**
 * @author derekyi
 * @date 2020/12/5
 */
public class EventAndEventListenerTest {

	@Test
	public void testEventListener() throws Exception {
		// 容器初始化时会创建RefreshedEvent
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");

		TimeUnit.SECONDS.sleep(3);
		// 手动发布自定义事件
		applicationContext.publishEvent(new CustomEvent(applicationContext));
		TimeUnit.SECONDS.sleep(3);
		// 设置容器关闭时发布ClosedEvent
		applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
		TimeUnit.SECONDS.sleep(3);

	}
}
