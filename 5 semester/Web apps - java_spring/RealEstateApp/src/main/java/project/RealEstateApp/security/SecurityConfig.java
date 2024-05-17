package project.RealEstateApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig {
	
	
	private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, CustomAuthenticationProvider customAuthenticationProvider) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(customAuthenticationProvider)
            .userDetailsService(userDetailsServiceImpl)
            .passwordEncoder(passwordEncoder());
    }

	@Bean
   	SecurityFilterChain securityFilterChain(HttpSecurity http,
   	                                        MvcRequestMatcher.Builder mvc) throws Exception {
   	    http
   	        .authorizeHttpRequests(authorize -> authorize
   	            .anyRequest().permitAll()
   	        )
   	        .formLogin(login -> login
   	            .loginPage("/login")
   	            .loginProcessingUrl("/login")
   	            .defaultSuccessUrl("/view_personal")
   	            .usernameParameter("email")
   	            .permitAll()
   	            
   	        )
   	        .logout(logout -> logout
   	            .logoutUrl("/logout")
   	            .logoutSuccessUrl("/offers")
   	        );
   	    
   	    http
   	    	.sessionManagement(httpSecuritySessionManagementConfigurer -> 
   	    		httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

   	    return http.build();
   	}

   	
	@Bean
    static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   	
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
   
}
