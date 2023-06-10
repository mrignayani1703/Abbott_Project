package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

    public class ExtentManager {
        private static ExtentReports extent;
        public static ExtentReports getInstance() {
            if (extent == null) {
                String reportFolderPath = "reports/";
                String reportFileName = "report.html";
                String reportPath = reportFolderPath + reportFileName;
                extent = new ExtentReports();
                ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
                extent.attachReporter(htmlReporter);
            }
            return extent;
        }

        public static ExtentTest createTest(String testName) {
            return extent.createTest(testName);
        }
    }