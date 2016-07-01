package com.zzw.service.configurations;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public final class Configurations extends Configuration {
	private static Configurations instance = new Configurations();

	private Configurations() {
	}

	@NotNull
	@JsonProperty
	private FrameServiceConfiguration frameServiceConfiguration = new FrameServiceConfiguration();

	public static synchronized Configurations getInstance() {
		return instance;
	}

	public static void setInstance(Configurations instance) {
		Configurations.instance = instance;
	}

	public FrameServiceConfiguration getFrameServiceConfiguration() {
		return frameServiceConfiguration;
	}

}
