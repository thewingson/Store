package kz.almat.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kz.almat")
public class AppConfig implements WebMvcConfigurer {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/view/**").addResourceLocations("/view/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure().baselineOnMigrate(true).locations("/db/migration").dataSource(
                environment.getRequiredProperty("spring.datasource.url"),
                environment.getRequiredProperty("spring.datasource.username"),
                environment.getRequiredProperty("spring.datasource.password"))
                .load();
        return flyway;
    }

}
