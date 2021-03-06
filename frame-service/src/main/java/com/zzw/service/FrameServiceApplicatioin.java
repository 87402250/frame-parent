package com.zzw.service;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import com.zzw.service.camel.UserRouteBuilder;
import com.zzw.service.configurations.Configurations;
import com.zzw.service.logger.FrameServiceLogger;
import com.zzw.service.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class FrameServiceApplicatioin extends Application<Configurations> {

	private final CamelContext camelContext = new DefaultCamelContext();
	private Configurations configurations;
	private Environment environment;

	@Override
	public void run(Configurations configuration, Environment environment) throws Exception {
		// this.configurations = configurations;
		this.environment = environment;

		Configurations.setInstance(configurations);
		registerService();
		startRouteBuilder();

	}

	private void startRouteBuilder() throws Exception {
		camelContext.addRoutes(new UserRouteBuilder());
		camelContext.start();
	}

	public void registerService() {
		// register resource
		environment.jersey().register(new UserResource(camelContext));
		// register logger info
		FrameServiceLogger.initialize(environment);
	}

	public static void main(String[] args) throws Exception {
		new FrameServiceApplicatioin().run(args);
	}

}
