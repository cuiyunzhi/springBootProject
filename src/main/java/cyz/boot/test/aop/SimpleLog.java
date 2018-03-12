package cyz.boot.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SimpleLog {
	private final Logger log = LoggerFactory.getLogger(SimpleLog.class);

	@Around("execution(* cyz.boot.test.controller.*.*(..)) ")
	public Object aroudAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("========log print=========="+log.isDebugEnabled());
		log.debug("========debug log print=========="+log.isDebugEnabled());
		if (log.isDebugEnabled()) {
			long start=0;
			log.debug("{}-参数：{}", pjp.getSignature(), pjp.getArgs());
			Object o=null;
			try {
				start=System.currentTimeMillis();
				o = pjp.proceed();
				return o;
			} finally {
				log.debug("{}-结果({}mm)：{}", pjp.getSignature(),(System.currentTimeMillis()-start), o);
			}
		} else {
			return pjp.proceed();
		}
	}

	@AfterThrowing(value="execution(* cyz.boot.test..*.*(..))",throwing="ex")
	public void exceptionAdvice(JoinPoint jp, Exception ex) {
		log.error("异常方法：{}，参数：{}",jp.getSignature(),jp.getArgs());
		log.error("异常堆栈" , ex);
	}
}
