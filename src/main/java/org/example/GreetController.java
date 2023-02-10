package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api")
public class GreetController {


    private final RestTemplate restTemplate;

    @Value("${nameServiceUrl}")
    private String namingURL;

    @Value("${test}")
    private String test;


    public GreetController() {
        RestTemplate restTemplate = new RestTemplate();
        this.restTemplate = restTemplate;
    }


    @GetMapping("/greet")
    public String getGreetMessage() {
        ResponseEntity<String> response = restTemplate.getForEntity(namingURL, String.class);
        return response.getBody();
    }

    @GetMapping("/test")
    public String getTestMessage() {
        return test;
    }

}
