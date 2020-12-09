package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.*;

@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
public class FormaterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getMeowConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getLocalDateConverter());
        registry.addConverter(getCommentConverter());
        registry.addConverter(getPrivateMeowConverter());
        registry.addConverter(getLocalDateTimeConverter());
    }

    @Bean
    public MeowConverter getMeowConverter(){ return new MeowConverter(); }
    @Bean
    public UserConverter getUserConverter(){return  new UserConverter(); }
    @Bean
    public LocalDateConverter getLocalDateConverter(){return new  LocalDateConverter();}
    @Bean
    public CommentConverter getCommentConverter(){return new CommentConverter();}
    @Bean
    public PrivateMeowConverter getPrivateMeowConverter() {return new PrivateMeowConverter();}
    @Bean
    public LocalDateTimeConverter getLocalDateTimeConverter() {return new LocalDateTimeConverter();}
}

