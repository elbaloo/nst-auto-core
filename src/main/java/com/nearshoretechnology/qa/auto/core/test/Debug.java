package com.nearshoretechnology.qa.auto.core.test;

import org.testng.annotations.Test;

import com.nearshoretechnology.qa.auto.core.util.TestStepRecorder;

public class Debug extends TestBase {

	@Test
	public void testTestStepRecorder() {
		TestStepRecorder tsr;

		tsr = new TestStepRecorder();

		tsr.startRecording()
			.ra()
			.ra()
			.ra()
			.ra();
	}

}
