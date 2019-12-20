package kz.almat.config;

import kz.almat.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("kz.almat.security")
@PropertySource(value= {"classpath:security.properties"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Value("${security.sign-in.message.invalid}")
    private String INVALID_DATA;
    @Value("${security.sign-in.message.sign-out}")
    private String SIGN_IN;

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                .antMatchers("/vendors/**","/users/**","/**/create", "/**/delete/**", "/**/update/**", "/admin/**").hasAuthority("ADMIN")
                .antMatchers("/orders/**").authenticated()
                .antMatchers("/orders/cart", "/orders/addToCart/**", "/orders/removeFromCart/**").permitAll()

                .anyRequest().permitAll()

                .and()
                .formLogin()
                .loginPage("/sign-in")
                .failureUrl("/auth/signIn?message=" + INVALID_DATA)
                .permitAll()

                .and()
                .logout().permitAll().deleteCookies("JSESSIONID")
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/auth/signIn?message=" + SIGN_IN)
                .invalidateHttpSession(true)

                .and()
                .rememberMe().key("rememberMe").tokenValiditySeconds(86400)

                .and()
                .csrf().disable();

    }



}