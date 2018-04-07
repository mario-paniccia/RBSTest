package com.example.rbstest.service;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DefaultPrimesServiceTest {

    DefaultPrimesService defaultPrimesService;

    @Before
    public void setup() {
        defaultPrimesService = new DefaultPrimesService();
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsNegative() {

        List<Integer> primes = defaultPrimesService.findPrimes(-2);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsZero() {

        List<Integer> primes = defaultPrimesService.findPrimes(0);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsOne() {

        List<Integer> primes = defaultPrimesService.findPrimes(1);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRetuningOneElementList() {

        List<Integer> primes = defaultPrimesService.findPrimes(2);

        assertThat(primes, contains(2));
    }

    @Test
    public void testPrimesGenerationWithBoundReturned() {

        List<Integer> primes = defaultPrimesService.findPrimes(7);

        assertThat(primes, contains(2, 3, 5, 7));
    }

    @Test
    public void testPrimesGenerationWithBoundNotReturned() {

        List<Integer> primes = defaultPrimesService.findPrimes(10);

        assertThat(primes, contains(2, 3, 5, 7));
    }

}