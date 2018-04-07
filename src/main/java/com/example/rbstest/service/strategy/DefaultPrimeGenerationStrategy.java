package com.example.rbstest.service.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.primes.Primes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultPrimeGenerationStrategy implements PrimeGenerationStrategy {

    public static final Logger logger = LoggerFactory.getLogger(DefaultPrimeGenerationStrategy.class);

    @Override
    public List<Integer> findPrimes(int bound) {
        logger.info("find primes");
        return IntStream.rangeClosed(2, bound)
                .filter(x -> Primes.isPrime(x)).boxed()
                .collect(Collectors.toList());
    }
}
