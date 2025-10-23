package Experimentation.Components;

public class ProductLane extends Lane {
    public static final int IDENTITY = 1;
    private int multiplicand;

    public ProductLane(int multiplicand) {
        this.multiplicand = multiplicand;
        operationSymbol = "×";
    }

    @Override
    public boolean checkResponse() {
        return response * multiplicand == currentBlock.getNumber();
    }

    public int getMultiplicand() {
        return multiplicand;
    }
}
