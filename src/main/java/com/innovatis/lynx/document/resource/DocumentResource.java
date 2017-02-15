package com.innovatis.lynx.document.resource;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

/**
 * Created by Ramakrishna Chalasani 02/14/2017
 */
@Api(value="documents", description = "Document Resource")
@Component("documentsResource")
@Path("/documents")
public class DocumentResource {


}
