package Experimentation.Components.Lanes;

import Experimentation.Components.Block.Block;
import Experimentation.Components.Input.Input;

public abstract class Lane {
    protected String operationSymbol;
    protected Block currentBlock;
    protected int response;

    public void setResponse(int response) {
        this.response = response;
    }

    public abstract boolean checkResponse();

    public abstract void parseResponse(Input input);
}