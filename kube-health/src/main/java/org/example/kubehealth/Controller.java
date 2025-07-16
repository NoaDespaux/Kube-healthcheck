package org.example.kubehealth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        RestTemplate restTemplate = new RestTemplate();
        String helloServiceUrl = System.getenv().getOrDefault("HELLO_SERVICE_URL", "http://localhost:8080/hello");
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(helloServiceUrl, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok("UP");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DOWN");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DOWN");
        }
    }

}
