package com.bi.cloud.web.config;

import com.bi.cloud.web.security.service.impl.UserDetailsServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Log logger = LogFactory.getLog(WebSecurityConfig.class);

    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;

    @Autowired
    private CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

    @Autowired
    private CustomizeAuthenticationFailureHandler customizeAuthenticationFailureHandler;

    @Autowired
    private CustomizeLogoutSuccessHandler customizeLogoutSuccessHandler;

    @Autowired
    private CustomizeSessionInformationExpiredStrategy customizeSessionInformationExpiredStrategy;


    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式（强hash方式加密）
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 让登录页指向对应的请求路径和启用"记住我（Remember Me）"功能
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info(" - - - - - - - - - - [ begin ] 初始化限制请求  - - - - - - - - - - ");
        http.cors().and().csrf().disable();
        // 限定签名后的权限
        http.
                authorizeRequests()
                .antMatchers("/user/**").hasAnyAuthority("ADMIN")
                // 所有请求都要验证
                .anyRequest().authenticated()
                //.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                //    @Override
                //    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                //        o.setAccessDecisionManager(accessDecisionManager);//决策管理器
                //        o.setSecurityMetadataSource(securityMetadataSource);//安全元数据源
                //        return o;
                //    }
                //})
                // 登出
                .and().logout()
                // 允许所有用户
                .permitAll()
                .logoutSuccessHandler(customizeLogoutSuccessHandler)
                // 登出之后删除cookie
                .deleteCookies("JSESSIONID")
                // 登陆
                .and().formLogin()
                    .permitAll()
                    // 成功
                    .successHandler(customizeAuthenticationSuccessHandler)
                    // 失败
                    .failureHandler(customizeAuthenticationFailureHandler)
                // 异常处理
                .and().exceptionHandling()
                    // 权限拒绝处理逻辑
                    //.accessDeniedHandler(accessDeniedHandler)
                    // 匿名用户访问无权限资源时的异常处理
                    .authenticationEntryPoint(customizeAuthenticationEntryPoint)
                // 会话管理
                .and().sessionManagement()
                    // 同一账号同时登录最大用户数
                    .maximumSessions(1)
                    // 会话失效(账号被挤下线)处理逻辑
                    .expiredSessionStrategy(customizeSessionInformationExpiredStrategy);
        logger.info(" - - - - - - - - - - [ end ] 初始化限制请求  - - - - - - - - - - ");

        http.headers().cacheControl();
    }

}
