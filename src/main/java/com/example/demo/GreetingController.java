package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Resource controller
// HTTP requests: handled by a controller, @RestController
// GreetingController class handles GET requests for /greeting by returning a new instance of the Greeting class

// The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.

// @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. If
//the name parameter is absent in the request, the defaultValue of World is used.

//The implementation of the method body creates and returns a new Greeting object with id and content attributes based
// on the next value from the counter and formats the given name by using the greeting template.

//this RESTful web service controller populates and returns a Greeting object. The object data will be written directly
// to the HTTP response as JSON.

//@RestController annotation, which marks the class as a controller where every method returns a domain object instead
// of a view. I
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
