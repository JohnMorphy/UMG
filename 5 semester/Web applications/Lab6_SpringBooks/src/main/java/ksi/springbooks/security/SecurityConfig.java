package ksi.springbooks.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http,
			MvcRequestMatcher.Builder mvc) throws Exception {
	http
		.csrf(Customizer.withDefaults())
		.authorizeHttpRequests(authorize -> authorize
		.requestMatchers(mvc.pattern("/new_book"), mvc.pattern("/edit_book/**"), mvc.pattern("/delete_book/**")).hasRole("BOOK_MANAGER")
		.requestMatchers(mvc.pattern("/new_book"), mvc.pattern("/edit_book/**"), mvc.pattern("/delete_book/**"),
				mvc.pattern("/new_category"), mvc.pattern("/edit_category/**"), mvc.pattern("/delete_category/**"),
				mvc.pattern("new_publisher"), mvc.pattern("/edit_publisher/**"), mvc.pattern("/delete_publisher/**")).hasRole("ADMIN")
		.anyRequest().permitAll()
		)
	.formLogin(form -> form
			 .loginPage("/login")
			 .loginProcessingUrl("/login")
			 .defaultSuccessUrl("/")
			 .permitAll())
	.logout(logout -> logout
			.logoutUrl("/logout")
		    .logoutSuccessUrl("/logout_message")
		);
	
	return http.build();
	}

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode("passu1");
		System.out.println(result);
	}
	
	
}
