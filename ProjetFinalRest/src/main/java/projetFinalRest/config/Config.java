package projetFinalRest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import projetFinal.config.JpaConfig;

@Configuration
@EnableWebMvc
@ComponentScan("ProjetFinal.restcontroller")
@Import(JpaConfig.class)
public class Config {

}
