package com.maodun.restTemplate;


import com.maodun.FeignApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@RestClientTest(value = FeignApp.class)
@ActiveProfiles("resttemplate")
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

}
