package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.ScreenshotUtil;

import java.io.ByteArrayInputStream;

public class CucumberHooks extends BaseTest {

    @Before
    public void scenarioSetUp() {
        setUp();
    }

    @After
    public void scenarioTearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] screenshot = ScreenshotUtil.captureScreenshot();
            Allure.addAttachment("Failure Screenshot", "image/png",
                    new ByteArrayInputStream(screenshot), ".png"
            );
        }
        tearDown();
    }
}