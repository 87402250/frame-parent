package com.zzw.service.configurations;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

public class FrameServiceConfiguration extends Configuration {
	
	/**
	 * The configuration file path of logback.
	 */
	@NotEmpty
	private String logbackConfigFilePath = "src/main/resources/logback.xml";

	public String getLogbackConfigFilePath() {
		return logbackConfigFilePath;
	}

	public void setLogbackConfigFilePath(String logbackConfigFilePath) {
		this.logbackConfigFilePath = logbackConfigFilePath;
	}

}
