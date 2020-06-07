package com.vmware.question.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.question.exception.InvalidInputException;
import com.vmware.question.model.Input;
import com.vmware.question.service.NumberService;
import com.vmware.question.util.Status;

@RestController
public class NumberController {
	
	@Autowired
	NumberService numberService;

	@GetMapping(value = "/api/{uuid}")
	Map<String, String> getAction(@PathVariable("uuid") String uuid, @RequestParam(required = true) String action)
	{
		if(!"get_numlist".equalsIgnoreCase(action))
			throw new InvalidInputException();
		Map<String, String> map = new HashMap<>();
		map.put("result",numberService.getOutput(uuid));
		return map;
	}

	@GetMapping(value = "/api/{uuid}/status")
	Map<String, Status> getStatus(@PathVariable("uuid") String uuid) {
		Map<String, Status> map = new HashMap<>();
		map.put("result",numberService.getStatus(uuid));
		return map;
	}

	@PostMapping(value = "/api/generate")
	@ResponseStatus(HttpStatus.ACCEPTED)
	Map<String, String> generate(@RequestBody Input input) {
		Map<String, String> map = new HashMap<>();
		final String uuid = UUID.randomUUID().toString().replace("-", "");
		numberService.executeTask(input.getGoal(),input.getStep(), uuid);
		map.put("task",uuid);
		return map;
	}

	

}
