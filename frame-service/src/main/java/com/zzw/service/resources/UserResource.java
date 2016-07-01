package com.zzw.service.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.camel.CamelContext;

import com.zzw.service.api.User;
import com.zzw.service.constans.ResourcePath;

@Path(ResourcePath.USER)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	private CamelContext camelContext;

	public UserResource(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@POST
	@Path("/search")
	public Response search(User user) {
		System.out.println("come in /user/search");
		return null;
	}

}
