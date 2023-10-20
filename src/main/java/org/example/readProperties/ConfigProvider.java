package org.example.readProperties;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }
    String URL = config.getString("url");
    String LOGIN_STANDARD_USER = config.getString("usersParams.standard_user.login");
    String PASSWORD_STANDARD_USER = config.getString("usersParams.standard_user.password");
    String LOGIN_LOCKED_OUT_USER = config.getString("usersParams.locked_out_user.login");
    String PASSWORD_LOCKED_OUT_USER = config.getString("usersParams.locked_out_user.password");
    String LOGIN_PROBLEM_USER = config.getString("usersParams.problem_user.login");
    String PASSWORD_PROBLEM_USER = config.getString("usersParams.problem_user.password");
    String SUCCESS_ORDER_MESSAGE = config.getString("success_order_message");
    String LOCKED_OUT_USER_AUTH_MESSAGE = config.getString("locked_out_user_auth_message");
    String WRONG_AUTH_MESSAGE = config.getString("wrong_auth_message");
}
