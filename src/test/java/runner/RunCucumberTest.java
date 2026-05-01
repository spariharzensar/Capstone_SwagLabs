package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "base"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber.html"},
//        tags = "@inventory",
        monochrome = true
)
@Listeners(listeners.RetryListener.class)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
