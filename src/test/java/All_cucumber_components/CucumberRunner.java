package All_cucumber_components;


import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class CucumberRunner {
	
	
	    //in feature we put the feature fil path from src until .feature....
	    //in glue with put the name of page which includes step definition class
	@CucumberOptions(tags = "", features = {"/ClearStack/src/main/java/Features/testScenario.feature"}, glue = {"All_cucumber_components"},
	                 plugin = {})
	public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
	    
	}
}

