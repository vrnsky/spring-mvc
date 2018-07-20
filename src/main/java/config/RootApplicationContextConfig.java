package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

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

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


}
