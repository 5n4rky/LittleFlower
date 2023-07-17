package com.LittleFlower.staffinformationsystem.config;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.internal.NativeQueryReturnBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.LittleFlower.staffinformationsystem.filter.JwtTokenFilter;
import com.LittleFlower.staffinformationsystem.service.impl.UserDetailServiceImp;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImp userDetailService;
	@Autowired
	private JwtTokenFilter jwtTokenFilter;
	/*
	 * @Autowired private final JwtTokenFilter jwtTokenFilter;
	 */
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
    	 // Enable CORS and disable CSRF
     //   http = http.cors().and().csrf().disable();
        
		/*
		 * // Set session management to stateless http = http .sessionManagement()
		 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) .and();
		 * 
		 * // Set unauthorized requests exception handler http = http
		 * .exceptionHandling() .authenticationEntryPoint( (request, response, ex) -> {
		 * response.sendError( HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage() ); }
		 * ) .and();
		 */
        // Set permissions on endpoints
        http.csrf().disable().authorizeRequests()
            // Our public endpoints
            .antMatchers("/login").permitAll()
            .antMatchers("/api/logout").permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter,UsernamePasswordAuthenticationFilter.class);
        
		
     
    	
    	
    	
    	
    }
    @Bean
    public AuthenticationManager authenticationManagerBean()throws Exception{
    	return super.authenticationManagerBean();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	//return new BCryptPasswordEncoder();
    	return  NoOpPasswordEncoder.getInstance();
    }
	

	
	

}
