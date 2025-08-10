package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})
public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();
    @Key("browserVersion")
    @DefaultValue("128.0")
    String browserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("baseUrl")
    @DefaultValue("https://x5.tech/")
    String baseUrl();
    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
    @Key("remoteUrl")
    @DefaultValue("https://x5.tech/")
    String remoteUrl();
}

