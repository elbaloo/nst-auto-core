package com.nearshoretechnology.qa.auto.core.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nearshoretechnology.qa.auto.api.TestLinkClient;
import com.nearshoretechnology.qa.auto.api.TestLinkTestData;

import testlink.api.java.client.TestLinkAPIException;

public abstract class TestBase {

	protected WebDriver webDriver;
	protected TestLinkClient tlClient;
	protected TestLinkTestData tlData;

	@BeforeClass
	public void _beforeClass() {
		tlClient = new TestLinkClient();
		tlData = new TestLinkTestData();
		tlData.projectName = "CD-POC";
		tlData.testPlanName = "CD-POC_TP";
		tlData.buildName = "Latest";
		tlData.testCaseName = this.getClass().getSimpleName();
	}

	@BeforeMethod
	public void _beforeMethod() {
		webDriver = new ChromeDriver();
	}

	@AfterMethod
	public void _afterMethod(ITestResult testResult) throws TestLinkAPIException {
		tlClient.reportTestCaseResult(tlData, testResult);
		webDriver.quit();
	}

}
