package com.example.rbstest.service;

import java.util.List;

import com.example.rbstest.service.strategy.PrimeGenerationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

@Service
public class CachePrimesService implements PrimesService {

    @Autowired
    PrimeGenerationStrategy primeGenerationStrategy;

    @Cacheable("primesCache")
    @Override
    public List<Integer> findPrimes(int bound) {
        return primeGenerationStrategy.findPrimes(bound);
    }

}
