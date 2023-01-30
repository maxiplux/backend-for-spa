package io.maxiplux.spa.config.security;

import io.maxiplux.spa.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.util.Arrays;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
    @Autowired
    private LoginSuccessHandler successHandler;

    @Autowired
    @Qualifier("CustomUserDetailsService")
    private CustomUserDetailsService userDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http
                .authorizeRequests()

                .antMatchers("/index.html").hasAnyRole("USER","ADMIN")
                .antMatchers("/app/api/v1/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin/admin.html").hasRole("ADMIN")
                .and()
                .formLogin()

                .and()
                .logout();

//        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
//
//                /*.antMatchers("/ver/**").hasAnyRole("USER")*/
//                /*.antMatchers("/uploads/**").hasAnyRole("USER")*/
//                /*.antMatchers("/form/**").hasAnyRole("ADMIN")*/
//                /*.antMatchers("/eliminar/**").hasAnyRole("ADMIN")*/
//                /*.antMatchers("/factura/**").hasAnyRole("ADMIN")*/
//
//                .anyRequest().authenticated()
//
//                .and()
//                .formLogin()
//                .successHandler(successHandler)
//
//                .loginPage("/login")
//
//                .permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/error_403");


    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        build.userDetailsService(userDetailsService)
                .passwordEncoder(this.passwordEncoder());

    }



    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/error_403").setViewName("error_403");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
