package com.nearshoretechnology.qa.auto.core.util;

public class TestStepRecorder {

	public TestStepRecorder() {
		
	}

	public Step startRecording() {
		return new Step() {
			@Override
			public Step ra() {
				return null;
			}
		};
	}

	public interface Step {
		Step ra();
	}

}
