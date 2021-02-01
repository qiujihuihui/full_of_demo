package com.module.demo.proxy_pattern;

/**
 * Created by shenh
 * On 2020/7/15
 * Description:
 */
public class UserController implements IUserController
{
    //...省略其他属性和方法...

    @Override
    public String login(String userName, String password)
    {
        //...省略login逻辑...
        return null;
    }

    @Override
    public String register(String userName, String password)
    {
        //...省略register逻辑...
        return null;
    }
}
