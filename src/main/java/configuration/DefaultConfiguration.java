package configuration;

public class DefaultConfiguration {
//    It will set "Chrome" as the default browser
    public static final String browserName = System.getProperty("browserName", "chrome");

//    It will set "Local" as the default environment for test execution
//    public static final String environment = System.getProperty("platform", "local");

//    It will be used to set "Docker Standalone" as the default environment for test execution
//    public static final String environment = System.getProperty("platform", "docker-compose-standalone");

    //    It will be used to set "Docker Grid" as the default environment for test execution
    public static final String environment = System.getProperty("platform", "docker-compose-grid");

    //    It will be used to set "Jenkins" as the default environment for test execution
//    public static final String environment = System.getProperty("platform", "jenkins");

//    It will be used to set "GitHubActions" as the default environment for test execution
//    public static final String environment = System.getProperty("platform", "GitHubActions");
}
