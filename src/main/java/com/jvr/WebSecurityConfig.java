package com.jvr;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@ComponentScan
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DataSource dataSource;
    
    /*
    @Bean
    public DataSource appDataSource() {
        System.out.println("Preparing datasource");
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:"+System.getProperty("java.io.tmpdir")+"/database");
        return dataSource;
    }*/
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("dataSource:" + dataSource);
        //auth.inMemoryAuthentication().withUser("Onep");
        //auth.
        auth
            .jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select userID ,password, true as enabled from user where userID=?")
            .authoritiesByUsernameQuery("select userID, role from userrole where userID=?");
        /*
        auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema().withUser("Onep").password("password").roles("Provider")
            .and().withUser("Oner").password("password").roles("Receiver");
        */
    }
}
