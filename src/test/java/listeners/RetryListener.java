package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import utils.RetryFailedScenarios;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor tectConstructor,
                          Method testMethod) {
        if (testMethod != null && testMethod.getName().equals("runScenario")) {
            annotation.setRetryAnalyzer(RetryFailedScenarios.class);
        }
    }
}
