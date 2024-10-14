package base;

public class DefaultConfiguration {
//    It will set Chrome as the default browser
    public static final String browserName = System.getProperty("browserName", "chrome");
//    public static final String platform = System.getProperty("platform", "remote_git");
    public static final String platform = System.getProperty("platform", "local");
}
