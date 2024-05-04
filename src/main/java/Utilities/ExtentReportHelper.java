package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportHelper {
    public static ExtentReports extentReports;
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss");


    public static ExtentReports getReport() {
//        Defining a path to save the report
        String reportPath = "./Report/"+dateTimeFormatter.format(LocalDateTime.now());
//        Using Spark reporter and passing the report variable as a parameter
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Automation Results");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentSparkReporter.config().setJs("document.getElementsByClassName('col-sm-12 col-md-4')[0].style.setProperty('min-inline-size','-webkit-fill-available');");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester Name: ","Danish Sayed");
        return extentReports;
    }
}
