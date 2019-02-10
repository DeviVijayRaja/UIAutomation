package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.SeMethods;

public class Hooks extends SeMethods{

	@Before
	public void before(Scenario sc) {
		startResult();
		startTestModule(sc.getName(), sc.getId());
		test = startTestCase(sc.getName());
		test.assignCategory("functional");
		test.assignAuthor();		
		}

	@After
	public void after(Scenario sc) {
		closeBrowser();
		endResult();		
	}
}









