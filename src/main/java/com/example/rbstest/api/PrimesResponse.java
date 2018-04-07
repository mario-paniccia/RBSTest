package com.example.rbstest.api;

import java.util.List;

public class PrimesResponse {

    private int initial;
    private List<Integer> primes;

    public PrimesResponse() {
    }

    public PrimesResponse(int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public int getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
