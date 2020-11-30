package com.example.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/hello")
@Api(value = "HelloResource", description = "Hello Resource REST API", tags = { "HelloResource" })
public class HelloResource {
	
	@GetMapping
	//use to change the method name in Swagger UI
	@ApiOperation(value = "Returns Hello World")
	//we can also add our own API response
	@ApiResponses(value = {
			@ApiResponse(code = 100,message = "100 is the message"),
			@ApiResponse(code = 20000,message = "Successfull message")
	})
	public String hello() {
		return "Hello World";
	}

	@PostMapping("/post")
	public String helloAdd(@RequestBody final String hello) {
		return hello;
	}
	
	@PostMapping("/put")
	public String helloUpdate(@RequestBody final String hello) {
		return hello;
	}
}
