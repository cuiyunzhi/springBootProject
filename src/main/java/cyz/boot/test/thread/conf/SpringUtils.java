package cyz.boot.test.thread.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware{
//	public class SpringUtils extends ApplicationObjectSupport{
//getApplicationContext();
	private static ApplicationContext applicationContext;
	/**
     * 从spring容器中获取某个特定名字的bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
    public static Object getBeanFromClazz(Class<?> clazz){
    	String clazzName = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
    	String beanName = String.valueOf(clazzName.charAt(0)).toLowerCase().concat(clazzName.substring(1));
    	Object obj = getBean(beanName);
    	return obj;
    }
    @SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext)  {
		this.applicationContext = applicationContext;
	}
}
