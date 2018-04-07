package com.example.rbstest.service.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.primes.Primes;
import org.springframework.stereotype.Component;

@Component
public class DefaultPrimeGenerationStrategy implements PrimeGenerationStrategy {

    @Override
    public List<Integer> findPrimes(int bound) {
        return IntStream.rangeClosed(2, bound)
                .filter(x -> Primes.isPrime(x)).boxed()
                .collect(Collectors.toList());
    }
}
