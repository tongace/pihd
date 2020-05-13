package com.dxc.toyota.application.pihd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan("com.dxc.toyota.application.controllers")
public class ThymeleafConfig implements WebMvcConfigurer {
    private static final String UTF8 = "UTF-8";
    //
    @Autowired
    private ThymeleafProperties properties;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Autowired
    private ApplicationContext applicationContext;

    //
    @Bean
    public ThymeleafViewResolver javascriptThymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding(UTF8);
        resolver.setContentType("application/javascript");
        resolver.setViewNames(new String[]{"*.js"});
        resolver.setCache(this.properties.isCache());
        return resolver;
    }

    @Bean
    public SpringResourceTemplateResolver javascriptTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setOrder(1);
        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("WEB-INF/templates/js");
        resolver.setSuffix(".js");
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        resolver.setCharacterEncoding(UTF8);
        resolver.setCheckExistence(true);
        resolver.setCacheable(this.properties.isCache());
        return resolver;
    }

    @Bean
    public ThymeleafViewResolver htmlThymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding(UTF8);
        resolver.setContentType("text/html");
        resolver.setViewNames(new String[]{"*.html"});
        resolver.setCache(this.properties.isCache());
        return resolver;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setOrder(0);
        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("WEB-INF/templates/html");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding(UTF8);
        resolver.setCheckExistence(true);
        resolver.setCacheable(this.properties.isCache());
        return resolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/static/scripts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/static/images/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}

