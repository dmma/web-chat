package ua.dp.dmma.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ua.dp.dmma.configuration.condition.DatabaseCondition;
import ua.dp.dmma.configuration.condition.MemoryCondition;
import ua.dp.dmma.dao.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.dp.dmma")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean(name = "messageDAOService")
    @Conditional(value = DatabaseCondition.class)
    public MessageDAOService getMessageDAOService() {
        return new MessageDAOServiceImpl();
    }

    @Bean(name = "userDAOService")
    @Conditional(value = DatabaseCondition.class)
    public UserDAOService getUserDAOService() {
        return new UserDAOServiceImpl();
    }

    @Bean(name = "messageDAOService")
    @Conditional(value = MemoryCondition.class)
    public MessageDAOService getMessageDAOServiceMemory() {
        return new MessageDAOServiceMemoryImpl();
    }

    @Bean(name = "userDAOService")
    @Conditional(value = MemoryCondition.class)
    public UserDAOService getUserDAOServiceMemory() {
        return new UserDAOServiceMemoryImpl();
    }
}

