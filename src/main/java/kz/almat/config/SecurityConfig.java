package kz.almat.config;

import kz.almat.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("kz.almat.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    @Bean
//    public AuthenticationProvider getAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        return  provider;
//    }

//    @Autowired
//    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(getShaPasswordEncoder());
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                // starts authorizing configurations
                .authorizeRequests()
                // ignoring the guest's urls "
                .antMatchers("/users/**").hasAuthority("ADMIN")
                .antMatchers("/orders/**").authenticated()
                .antMatchers("/products/**").permitAll()
                // authenticate all remaining URLS
                .anyRequest().permitAll()
                .and()
                /* "/logout" will log the user out by invalidating the HTTP Session,
                 * cleaning up any {link rememberMe()} authentication that was configured, */
                .logout().permitAll()
                .and()
                // enabling the basic authentication
//                .httpBasic()
//                .and()
                // disabling the CSRF - Cross Site Request Forgery
                .csrf().disable();


    }

//    @Bean
//    public BCryptPasswordEncoder getShaPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

}