package com.example.rbstest.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.primes.Primes;
import org.springframework.stereotype.Service;

@Service
public class PrimesService {

    public static List<Integer> findPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> Primes.isPrime(x)).boxed()
                .collect(Collectors.toList());
    }

}
