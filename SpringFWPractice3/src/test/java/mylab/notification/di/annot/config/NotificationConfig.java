package mylab.notification.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "mylab.notification.di.annot")
@PropertySource("classpath:values.properties")
public class NotificationConfig {
}