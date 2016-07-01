package com.zzw.service.logger;

import org.slf4j.LoggerFactory;

import com.zzw.service.configurations.Configurations;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import io.dropwizard.setup.Environment;

public class FrameServiceLogger {

	public static void initialize(Environment environment) {
		reloadDropwizardLogger();
	}

	/**
	 * Reload log-back's configuration to use its full function since Dropwizard's build-in log-back have some functional limitation.
	 */
	private static void reloadDropwizardLogger() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			context.reset();
			String configFilePath = Configurations.getInstance().getFrameServiceConfiguration().getLogbackConfigFilePath();
			configurator.doConfigure(configFilePath);
		} catch (JoranException e) {
			throw new RuntimeException("Unable to initialize logging.", e);
		}
	}

}
