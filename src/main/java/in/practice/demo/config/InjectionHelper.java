package in.practice.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InjectionHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }
    private static void setContext(ApplicationContext applicationContext) {
        InjectionHelper.applicationContext = applicationContext;
    }
    public static <T> T getBean(Class<T> clazz) { return applicationContext.getBean(clazz); }
    public static <T> T getBean(String name) { return (T) applicationContext.getBean(name); }
}