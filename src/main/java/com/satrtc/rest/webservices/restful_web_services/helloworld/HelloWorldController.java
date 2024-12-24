package com.satrtc.rest.webservices.restful_web_services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	MessageSource messageSource;
	
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	//returning a string 
	@GetMapping(path = "/hello-world")
	public String helloworld()
	{
		return "Hello World";
	}
	
	//returning a java bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello world bean");
	}
	
	//returning bean with path including a path variable
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean("Hello world from, "+name);
	}
	
	//implementing internationalisation under content negotiation
	@GetMapping(path="/hello-world-i8n")
	public String helloWorldInternationalisation()
	{
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
	}
	
	//implementing versioning of REST API:
	
	//URI versioning 
	@GetMapping(path="/hello-world/v1")
	public Person personURIversion1()
	{
		return new Person("Matcha");
	}
	
	@GetMapping(path="/hello-world/v2")
	public Person personURIversion2()
	{
		return new Person("Mr. "+"Matcha");
	}
	
	
	//request parameter versioning
	@GetMapping(path="/hello-world/param",params = "version=1")
	public Person personParamVersion1()
	{
		return new Person("Mr. "+"Matcha"+" param version 1");
	}
	
	@GetMapping(path="/hello-world/param",params = "version=2")
	public Person personParamVersion2()
	{
		return new Person("Mr. "+"Matcha"+" param version 2");
	}
	
	
	//custom header versioning
	@GetMapping(path="/hello-world", headers="api-version=1")
	public Person personHeaderversion1()
	{
		return new Person("Mr. "+"Matcha"+" header version 1");

	}
	
	@GetMapping(path="/hello-world", headers="api-version=2")
	public Person personHeaderversion2()
	{	
		return new Person("Mr. "+"Matcha"+" header version 2");

	}
	
	
	//media type/ content negotiation versioning
	@GetMapping(path="/hello-world", produces="application/api-version-v1+json")
	public Person personMediaTypeversion1()
	{		
		return new Person("Mr. "+"Matcha"+" media type version 1");

	}
	
	@GetMapping(path="/hello-world", produces="application/api-version-v2+json")
	public Person personMediaTypeversion2()
	{		
		return new Person("Mr. "+"Matcha"+" media type version 2");

	}
}
