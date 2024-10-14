package base;

public class DefaultConfiguration {
//    It will set "Chrome" as the default browser
    public static final String browserName = System.getProperty("browserName", "chrome");

//    It will be used to set "Remote Git" as the default environment for test execution
//    public static final String platform = System.getProperty("platform", "remote_git");

//    It will set "Local" as the default environment for test execution
    public static final String platform = System.getProperty("platform", "local");
}
