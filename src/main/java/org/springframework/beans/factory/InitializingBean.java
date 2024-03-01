package org.springframework.beans.factory;

/**
 * @author derekyi
 * @date 2020/11/29
 */
public interface InitializingBean {

	/**
	 * 这是默认的初始化处理器，只要实现了InitializingBean接口就会有
	 * @throws Exception
	 */
	void afterPropertiesSet() throws Exception;
}
