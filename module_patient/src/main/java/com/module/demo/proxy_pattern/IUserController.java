package com.module.demo.proxy_pattern;

/**
 * Created by shenh
 * On 2020/7/15
 * Description:
 */
public interface IUserController
{
    String login(String userName, String password);

    String register(String userName, String password);
}
