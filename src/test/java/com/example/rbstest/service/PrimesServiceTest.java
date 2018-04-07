package com.example.rbstest.service;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PrimesServiceTest {

    PrimesService primesService;

    @Before
    public void setup() {
        primesService = new PrimesService();
    }

    @Test
    public void test() {

        List<Integer> primes = primesService.findPrimes(10);

        assertThat(primes, contains(2, 3, 5, 7));
    }

}