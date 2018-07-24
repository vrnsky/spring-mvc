package config;

import domain.Product;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Create embedded database beans and init named jdbc template for spring.
 * @author vrnsky.
 * @version 0.1
 */
@Configuration
public class RootApplicationContextConfig {

    /**
     * Creata a new data source which reference to the database.
     * @return data source ref to the embedded database.
     */
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase database = builder.setType(EmbeddedDatabaseType.HSQL).addScript("db/sql/create-table.sql").
                addScript("db/sql/insert-data.sql").build();
        return database;
    }


    /**
     * Create a wrapper for work with jdbc from spring.
     * @return spring wrapper for work with jdbc.
     */
    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    /**
     * Automate generate label for views.
     * @return source of messages.
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    /**
     * Generate a bean which allow to represent an product as json sequence.
     * @return beans which allow generate json for product.
     */
    @Bean
    public MappingJackson2JsonView jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

    /**
     * Generate a bean which allow to represent and product as xml tree.
     * @return bean which allow to generate xml tree for product.
     */
    @Bean
    public MarshallingView xmlView() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Product.class);
        return new MarshallingView(marshaller);
    }

    /**
     * Content negotiating manager which resolve how of view show to user.
     * @param manager of view.
     * @return configured resolver.
     */
    @Bean
    public ViewResolver contentNegotianResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<View> views = new ArrayList<>();
        views.add(jsonView());
        views.add(xmlView());
        resolver.setDefaultViews(views);
        return resolver;
    }




}
