package config;

import interceptors.ProcessingLogTimeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Config class, enable MVC of Spring by Enable MVC annotations.
 * Configure static resources such as images, pdf and others.
 * Also add bean for uploading a new file.
 * @author vrnsky.
 * @version 0.1
 */
@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ProcessingLogTimeInterceptor());
    }

    /**
     * Register a static resources which hold resources folder at the webapp.
     * @param registry spring register.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/manuals/**").addResourceLocations("/resources/manuals/");
    }

    /**
     * Add bean for uploading file to the server.
     * @return mulipart resolver which allow to work with files.
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10240000);
        return resolver;
    }
}
