/**
 * 
 */
package edu.uky.cepis.aop;

import java.io.Serializable;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * Provides Advice before calling method Class.<br/>
 * This can be used to check the validity of the parameters passed to a method,
 * change the parameter value passed.<br/>
 * <br/>
 * This class is configured in the Spring config file - cepisContext.xml.<br/>
 * This class is configured as an interceptor.<br/>
 * <br/>
 * <br/>
 * @author keerthi
 * 
 */
public class TracingBeforeAdvice implements MethodBeforeAdvice,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(TracingBeforeAdvice.class);

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		if (log.isDebugEnabled()) {
			System.out.println("Just before method call...");
		}
	}
}
