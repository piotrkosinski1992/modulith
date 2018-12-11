package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomAccountDetailsService accountDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(accountDetailsService).passwordEncoder(passwordEncoder);

        super.configure(auth);
    }

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
     //           .and()
   //             .authorizeRequests()
 //               .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")

//	        .antMatchers("/*").permitAll();

//	        .antMatchers("/user/hello").authenticated();
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
//	        .logoutUrl("/bank/logout")

        http.csrf().disable();
    }*/
}
