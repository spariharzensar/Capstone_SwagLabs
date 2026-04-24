package utils;

import base.DriverSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtil {

    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) DriverSetup.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}
