package com.example.rbstest.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.rbstest.service.strategy.PrimeGenerationStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CachePrimesServiceIT {

    @Autowired
    PrimesService service;

    @SpyBean
    PrimeGenerationStrategy primeGenerationStrategy;

    @Test
    public void testCacheHit() {

        service.findPrimes(2);
        service.findPrimes(2);

        verify(primeGenerationStrategy, times(1)).findPrimes(2);
    }

    @Test
    public void testCacheMiss() {

        service.findPrimes(4);
        service.findPrimes(10);

        verify(primeGenerationStrategy, times(1)).findPrimes(4);
        verify(primeGenerationStrategy, times(1)).findPrimes(10);
    }
}