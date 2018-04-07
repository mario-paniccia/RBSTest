package com.example.rbstest.service.strategy;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DefaultPrimeGenerationStrategyTest {

    DefaultPrimeGenerationStrategy strategy;

    @Before
    public void setup() {
        strategy = new DefaultPrimeGenerationStrategy();
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsNegative() {

        List<Integer> primes = strategy.findPrimes(-2);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsZero() {

        List<Integer> primes = strategy.findPrimes(0);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRerunsEmptyListWhenBoundIsOne() {

        List<Integer> primes = strategy.findPrimes(1);

        assertThat(primes, hasSize(0));
    }

    @Test
    public void testRetuningOneElementList() {

        List<Integer> primes = strategy.findPrimes(2);

        assertThat(primes, contains(2));
    }

    @Test
    public void testPrimesGenerationWithBoundReturned() {

        List<Integer> primes = strategy.findPrimes(7);

        assertThat(primes, contains(2, 3, 5, 7));
    }

    @Test
    public void testPrimesGenerationWithBoundNotReturned() {

        List<Integer> primes = strategy.findPrimes(10);

        assertThat(primes, contains(2, 3, 5, 7));
    }

}