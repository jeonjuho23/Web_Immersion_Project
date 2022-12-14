package com.example.springdemo.bean.annotation.property.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {

    private Environment env;
    private String adminId;
    private String adminPw;

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
        setAdminId(env.getProperty("admin.id"));
        setAdminPw(env.getProperty("admin.pw"));
    }


    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment()");
        setEnv(environment);
    }

    public void setEnv(Environment env) {
        this.env = env;
    }



    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {
        this.adminPw = adminPw;
    }


}
