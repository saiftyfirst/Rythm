package com.saiftyfirst.models;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {

    ADDITION('+') {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    SUBTRACTION('-') {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICATION('*') {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVISION('/') {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final char code;

    Operator(final char code) {
        this.code = code;
    }

    abstract public double apply(double x, double y);

    @Override
    public String toString() {
        return String.valueOf(code);
    }

    public static Operator getOperatorByCode(char code) {
        Optional<Operator> op = Arrays.stream(Operator.values())
                .filter(val -> val.code == code)
                .findAny();
        return op.orElse(null);
    }

}
