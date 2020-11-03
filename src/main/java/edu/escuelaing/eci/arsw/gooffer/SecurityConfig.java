package edu.escuelaing.eci.arsw.gooffer;

import edu.escuelaing.eci.arsw.gooffer.auth.handler.LoginSuccessHandler;
import edu.escuelaing.eci.arsw.gooffer.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuariosServices userDetailsService;

    @Autowired
    private BCryptPasswordEncoder  bCrypt;

    @Autowired
    private LoginSuccessHandler successHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/fonts/**");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Especificar el encargado del login y encriptacion del password
        auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                    .antMatchers(   "/usuarios", "/registro.html", "/servicios","/registroServicio.html", "/eliminarServicio.html","/servicios/**", "/usuarios/**","/contact.html","/index.html","/about.html").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin().successHandler(successHandler)
                    .loginPage("/loginprueba.html").permitAll()
                    .defaultSuccessUrl("/servicios.html", true)
                    .failureUrl("/login?error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout")
                    .and()
                .cors().and().
                csrf().disable();
    }
    
}
