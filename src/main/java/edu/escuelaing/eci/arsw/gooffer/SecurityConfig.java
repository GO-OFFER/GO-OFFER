package edu.escuelaing.eci.arsw.gooffer;

import edu.escuelaing.eci.arsw.gooffer.services.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.naming.AuthenticationNotSupportedException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuariosServices userDetailsService;

    @Autowired
    private BCryptPasswordEncoder  bCrypt;

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
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCrypt);
            //auth.userDetailsService(userDetailsService);
    }*/
    /*@Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder encoder = passwordEncoder();
        User.UserBuilder user = User.builder().passwordEncoder(encoder::encode);

        builder.inMemoryAuthentication()
        .withUser(user.username("admin").password("123").roles("vendedor","comprador"))
        .withUser(user.username("user").password("123").roles("vendedor","comprador"));
    }*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();

         */
        http
                .authorizeRequests()
                .antMatchers(   "/usuarios", "/registro.html", "/servicios","/registroServicio.html", "/eliminarServicio.html","/servicios/**", "/usuarios/**","/contact.html","/index.html","/about.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginprueba.html").permitAll()
                .and()
                .formLogin()
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
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/favicon.png",  "/usuarios", "/registro.html", "/servicios", "/servicios/**", "/usuarios/**","/contact.html","/index.html","/about.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/perfilVendedor", false)
                .failureUrl("/login?error")
                .usernameParameter("usuario")
                .passwordParameter("pass")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout")
                .and()
                .cors().and().
                csrf().disable();
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }*/
}
