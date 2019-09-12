package com.integrationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue="definitions",dryRun=false)
public class TestCucumberRunner {
	
	@Test
	public void contextLoads() {
	}
}

