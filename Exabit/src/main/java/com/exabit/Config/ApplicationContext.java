package main.java.com.exabit.Config;

import main.java.com.exabit.Config.Security.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Casperinous on 14/1/2016.
 */
@Configuration
@ComponentScan("main.java.com.exabit")
@EnableJpaRepositories(basePackages = "main.java.com.exabit.Repositories")
@Import({SecurityConfig.class, WebMvcContext.class, PersistenceConfig.class})
public class ApplicationContext {

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";


    @Bean
    PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
