package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {ServiceAppConfig.class,PersistenceAppConfig.class })
public class BusinessAppConfig {

}
