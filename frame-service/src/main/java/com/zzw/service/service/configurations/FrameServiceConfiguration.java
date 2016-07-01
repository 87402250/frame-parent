package com.zzw.service.service.configurations;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class FrameServiceConfiguration extends Configuration {
	@NotEmpty
	private String template;
	/**
	 * The configuration file path of logback.
	 */
	@NotEmpty
	private String logbackConfigFilePath = "src/main/resources/logback.xml";

	@NotEmpty
	private String defaultName = "Stranger";

	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String name) {
		this.defaultName = name;
	}

	public String getLogbackConfigFilePath() {
		return logbackConfigFilePath;
	}

	public void setLogbackConfigFilePath(String logbackConfigFilePath) {
		this.logbackConfigFilePath = logbackConfigFilePath;
	}

}
