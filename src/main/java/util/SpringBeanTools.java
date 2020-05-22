package util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanTools implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanTools.applicationContext=applicationContext;
    }

    public static <T> T getBeanByClassType(Class<T> classType){
        return applicationContext.getBean(classType);
    }
}
