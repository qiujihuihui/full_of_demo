package com.module.demo.proxy_pattern;

/**
 * Created by shenh
 * On 2020/7/15
 * Description:
 */
public class ProxyTest
{
    public String testLogin(String userName, String password){
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        return userController.login(userName, password);
    }

    public String testRegister(String userName, String password){
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        return userController.register(userName, password);
    }
}
