package com.example.rbstest.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import com.example.rbstest.api.PrimesResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimesControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturn200WhenSendingRequestToController() {
        ResponseEntity<PrimesResponse> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/primes/10", PrimesResponse.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getHeaders().getContentType(), equalTo(MediaType.APPLICATION_JSON_UTF8));
        PrimesResponse primesResponse = entity.getBody();
        assertThat(primesResponse.getInitial(), equalTo(10));
        assertThat(primesResponse.getPrimes(), contains(2, 3, 5, 7));
    }

    @Test
    public void shouldReturn200AndEmptyListWhenBoundIsInvalid() {
        ResponseEntity<PrimesResponse> entity = this.testRestTemplate.getForEntity(
                "http://localhost:" + this.port + "/primes/0", PrimesResponse.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        PrimesResponse primesResponse = entity.getBody();
        assertThat(primesResponse.getInitial(), equalTo(0));
        assertThat(primesResponse.getPrimes(), hasSize(0));
    }

    @Test
    public void shouldReturnResponseAsXMlWhenRequested() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = this.testRestTemplate.exchange(
                "http://localhost:" + this.port + "/primes/10", HttpMethod.GET, entity, String.class);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(result.getHeaders().getContentType().includes(MediaType.APPLICATION_XML), is(true));
    }
}
