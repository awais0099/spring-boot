package com.example.socialmediaapprestapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Firstname Lastname");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2("Firstname", "Lastname");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getFirstVersionOfPersonRequestParamV2() {
		return new PersonV2("Firstname", "Lastname");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonHeaderParamV1() {
		return new PersonV1("Firstname Lastname");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getFirstVersionOfPersonHeaderParamV2() {
		return new PersonV2("Firstname", "Lastname");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptParamV1() {
		return new PersonV1("Firstname Lastname");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getFirstVersionOfPersonAcceptParamV2() {
		return new PersonV2("Firstname", "Lastname");
	}
}
