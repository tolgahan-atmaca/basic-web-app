package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloworldController {
	@GetMapping("/hello")
	public String helloQuery(@org.springframework.web.bind.annotation.RequestParam(defaultValue = "Dünya") String name) {
		return "Merhaba " + name + "!";
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello, World! v2";
	}

	@GetMapping("/health")
	public Map<String, String> health() {
		Map<String, String> status = new HashMap<>();
		status.put("status", "UP");
		return status;
	}

	@GetMapping("/info")
	public Map<String, Object> info() {
		Map<String, Object> info = new HashMap<>();
		info.put("version", "1.0.0");
		info.put("buildTime", Instant.now().toString());
		info.put("env", System.getenv().getOrDefault("APP_ENV", "dev"));
		return info;
	}
}
