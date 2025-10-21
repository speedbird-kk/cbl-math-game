package Experimentation.Components;

public class ProductLane extends Lane {
    public static final int IDENTITY = 1;
    private int multiplicand;

    public ProductLane(int multiplicand) {
        this.multiplicand = multiplicand;
        operationSymbol = "×";
    }

    public int getMultiplicand() {
        return multiplicand;
    }
}
