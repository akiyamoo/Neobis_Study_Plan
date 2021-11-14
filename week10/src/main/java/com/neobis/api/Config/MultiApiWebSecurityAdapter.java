package com.neobis.api.Config;

import com.neobis.api.Config.JWT.JwtFilter;
import com.neobis.api.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MultiApiWebSecurityAdapter {

    @Autowired
    private UserServiceImpl userService;

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
        auth.userDetailsService(userService);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter{

        @Autowired
        private JwtFilter jwtFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")

                    .httpBasic().disable()

                    .csrf().disable()

                    .authorizeRequests()

                    .antMatchers("/api/admin/**").hasRole("ADMIN")

                    .antMatchers("/api/user/**").hasRole("USER")

                    .antMatchers("/api/auth", "/api/registration").permitAll()

                    .anyRequest().authenticated()
                    .and()

                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                    .and()

                    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }

    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter{

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .csrf()
                    .disable()
                    .authorizeRequests()

                    .antMatchers("/admin/**").hasRole("ADMIN")

                    .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")

                    .antMatchers("/registration", "/", "/help").permitAll()

                    .anyRequest().authenticated()
                    .and()

                    .formLogin()
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/user").permitAll()

                    .and()

                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .deleteCookies("JSESSIONID")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
        }
    }
}