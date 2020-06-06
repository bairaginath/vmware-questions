package com.vmware.question.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.question.model.Input;
import com.vmware.question.util.Status;

@RestController
public class NumberController {

	@GetMapping(value = "/api/{uuid}")
	Map<String, String> getAction(@PathVariable("uuid") String uuid, @RequestParam(required = true) String action)
	{
		Map<String, String> map = new HashMap<>();
		map.put("result","334343434ß");
		return map;
	}

	@GetMapping(value = "/api/{uuid}/status")
	Map<String, Status> getStatus(@PathVariable("uuid") String uuid) {
		Map<String, Status> map = new HashMap<>();
		map.put("result", Status.SUCCESS);
		return map;
	}

	@PostMapping(value = "/api/generate")
	@ResponseStatus(HttpStatus.ACCEPTED)
	Map<String, String> generate(@RequestBody Input input) {
		Map<String, String> map = new HashMap<>();
		map.put("task", String.valueOf(input.hashCode()));
		return map;
	}

	

}
