package com.example.rbstest.controller;

import java.util.List;

import com.example.rbstest.api.PrimesResponse;
import com.example.rbstest.service.PrimesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primes")
public class PrimesController {

    public static final Logger logger = LoggerFactory.getLogger(PrimesController.class);

    @Autowired
    PrimesService primesService;

    @GetMapping(value = "/{bound}")
    @ResponseBody
    public ResponseEntity<PrimesResponse> findPrimes(@PathVariable("bound") int bound) {
        logger.info("Retrieving primes up to {}", bound);
        List<Integer> primes = primesService.findPrimes(bound);

        PrimesResponse primesResponse = new PrimesResponse(bound, primes);
        return new ResponseEntity<>(primesResponse, HttpStatus.OK);
    }
}
