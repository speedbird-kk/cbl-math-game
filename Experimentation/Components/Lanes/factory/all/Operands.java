package Experimentation.components.lanes.factory.all;

import java.util.Random;

public record Operands(int multiplicand, int divisor, int summand, int subtrahend) {
    private static final Random RNG = new Random();

    Operands(int sumBound, int differenceBound) {
        this(
            RNG.nextInt(3, 10),
            RNG.nextInt(3, 10),
            RNG.nextInt(11, sumBound),
            RNG.nextInt(50, differenceBound)
        );
    }
}
