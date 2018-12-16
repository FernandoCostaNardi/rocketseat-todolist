package com.sysconard.Glojas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sysconard.Glojas.security.AppUserdetailService;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan(basePackageClasses = AppUserdetailService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserDetailsService userDetailsService;
   
	@Autowired 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   //auth.inMemoryAuthentication().withUser("admin").password("admin").roles("PESQUISA_PRODUTOS_GERAL");
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/layout/**")
				.antMatchers("/images/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.sessionManagement().enableSessionUrlRewriting(false);

		
		http
				.authorizeRequests()
			    	.antMatchers("/login/**").permitAll()
			    	.antMatchers("/","/login","/404").permitAll()
			    	.antMatchers("/usuarios/**").hasAnyAuthority("CADASTRAR_USUARIO")
			    	.antMatchers("/lojas/**").hasAnyAuthority("PESQUISA_ADM_GERAL")
			    	.antMatchers("/cargos/**").hasAnyAuthority("PESQUISA_ADM_GERAL")
			    	.antMatchers("/funcionarios/**").hasAnyAuthority("PESQUISA_ADM_GERAL")
			    	.antMatchers("/produtos/**").hasAnyAuthority("PESQUISA_PRODUTOS_GERAL")
			    	.antMatchers("/estoque/**").hasAnyAuthority("PESQUISA_ESTOQUE_GERAL")
			     	.antMatchers("/compras/**").hasAnyAuthority("PESQUISA_COMPRA_GERAL")
  				    .antMatchers("/vendas/**").hasAnyAuthority("PESQUISA_VENDAS_GERAL")
  				    .antMatchers("/comissao/**").hasAnyAuthority("PESQUISA_COMISSAO_GERAL")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
				//	.failureUrl("/login?error")
					.defaultSuccessUrl("/login/tenant")
					.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.and()
				.exceptionHandling()
					.accessDeniedPage("/{tenantid}/403")
				    .and()
				.sessionManagement()
					.invalidSessionUrl("/login")
					.maximumSessions(1)
					.expiredUrl("/login");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
}
