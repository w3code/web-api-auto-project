package io.github.w3code.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${environment}.properties",
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("91.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteDriverUrl")
    String remoteDriverUrl();
}
