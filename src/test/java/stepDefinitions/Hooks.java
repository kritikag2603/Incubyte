package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@Basic")
	public void before_basic_execution() {
		System.out.println("Before basic execution");
	}
	
	@After("@Basic")
	public void after_basic_execution() {
		System.out.println("After basic execution");
	}
	
	@Before("@Advanced")
	public void before_advanced_execution() {
		System.out.println("Before advanced execution");
	}
	
	@After("@Advanced")
	public void after_advanced_execution() {
		System.out.println("After advanced execution");
	}
}
