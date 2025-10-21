package Experimentation.Components;

public abstract class Lane {
    protected String operationSymbol;
    protected Block currentBlock;
    protected int response;

    public void setResponse(int response) {
        this.response = response;
    }

    public abstract boolean checkResponse();
}