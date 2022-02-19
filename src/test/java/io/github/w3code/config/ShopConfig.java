package io.github.w3code.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/shop.properties"})
public interface ShopConfig extends Config {
    @Key("shopUrl")
    String shopUrl();

    @Key("user")
    String user();

    @Key("password")
    String password();
}
