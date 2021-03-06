package kz.almat.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                AppConfig.class,
                HibernateConfig.class,
                SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                AppConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
