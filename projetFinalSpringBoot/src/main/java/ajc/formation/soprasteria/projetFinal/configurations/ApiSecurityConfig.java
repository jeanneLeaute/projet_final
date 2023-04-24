package ajc.formation.soprasteria.projetFinal.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class ApiSecurityConfig {
	
	  
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		//@formatter:off
		return http.antMatcher("/api/**")
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).permitAll()
					.antMatchers(HttpMethod.POST, "/api/**/inscription").anonymous()
					.antMatchers(HttpMethod.POST, "/api/client//inscription").anonymous()
					.antMatchers(HttpMethod.GET, "/api/**/login/check/**").anonymous()
					.antMatchers(HttpMethod.POST, "/api/reservation").hasAnyRole("CLIENT")
					.antMatchers(HttpMethod.GET, "/api/restaurant").hasAnyRole("CLIENT")
					.antMatchers(HttpMethod.POST, "/api/restaurant").hasAnyRole("RESTAURATEUR")
					.antMatchers(HttpMethod.GET, "/api/reservation").hasAnyRole("RESTAURATEUR")
					.antMatchers(HttpMethod.GET,"/api/restaurant").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.GET,"/api/restaurateur/**").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.GET,"/api/client/**").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.DELETE, "/api/restaurant/**").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.POST, "/api/restaurant/**").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.PUT, "/api/restaurant/**").hasAnyRole("ADMIN")
					.antMatchers(HttpMethod.GET, "/api/auth").authenticated()
					.anyRequest().hasAnyRole("ADMIN")
				.and()
				.httpBasic()
				.and()
				.build();
		//@formatter:on
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
