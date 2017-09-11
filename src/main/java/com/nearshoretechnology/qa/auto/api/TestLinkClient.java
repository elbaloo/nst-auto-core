package com.nearshoretechnology.qa.auto.api;

import org.testng.ITestResult;

import com.nearshoretechnology.qa.auto.api.TestLinkTestData;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIConst;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkClient {

	private String devKey;
	private String tlURL;
	private TestLinkAPIClient client;

	public TestLinkClient(String url, String devKey) {
		tlURL = url;
		this.devKey = devKey;
		initApiClient();
	}

	public TestLinkClient() {
		this("http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php",
				"dfcc32dbfd9cd60759d6702580340e5e");
	}

	private void initApiClient() {
		client = new TestLinkAPIClient(devKey, tlURL);
	}

	public void reportTestCaseResult(String projectName, String testPlanName, String buildName,
			String testCaseName, String testResultStatus, String execNotes) throws TestLinkAPIException {
		client.reportTestCaseResult(projectName, testPlanName, testCaseName, buildName, execNotes, testResultStatus);
	}

	public void reportTestCaseResult(TestLinkTestData tltd, ITestResult testResult, String notes) throws TestLinkAPIException {
		reportTestCaseResult(tltd.projectName, tltd.testPlanName, tltd.buildName, tltd.testCaseName,
				testResult.getStatus() == ITestResult.SUCCESS ? TestLinkAPIConst.TEST_PASSED :
					TestLinkAPIConst.TEST_FAILED, notes);
	}

	public void reportTestCaseResult(TestLinkTestData tltd, ITestResult testResult) throws TestLinkAPIException {
		reportTestCaseResult(tltd, testResult, "");
	}

}
