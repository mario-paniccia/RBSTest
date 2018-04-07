package com.example.rbstest.service;

import java.util.List;

import com.example.rbstest.service.strategy.PrimeGenerationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CachePrimesService implements PrimesService {

    public static final Logger logger = LoggerFactory.getLogger(CachePrimesService.class);

    @Autowired
    private PrimeGenerationStrategy primeGenerationStrategy;

    @Cacheable("primesCache")
    @Override
    public List<Integer> findPrimes(int bound) {
        logger.info("find primes");
        return primeGenerationStrategy.findPrimes(bound);
    }

}
