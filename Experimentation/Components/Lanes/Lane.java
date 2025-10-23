package Experimentation.Components.Lanes;

import Experimentation.Components.Block.Block;
import Experimentation.Components.Input.Input;

public abstract class Lane {
    protected int operand;
    protected String operationSymbol;
    protected Block currentBlock;
    protected int response;

    protected Lane(int operand, String operationSymbol) {
        this.operand = operand;
        this.operationSymbol = operationSymbol;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int getOperand() {
        return operand;
    }

    public abstract boolean checkResponse();

    public abstract void parseResponse(Input input);
}