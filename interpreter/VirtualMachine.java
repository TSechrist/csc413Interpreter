package interpreter;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning = true;
    private boolean isDumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {

    }

    public void setRunning(boolean boolRunning)
    {
        isRunning = boolRunning;
    }

    public void setDumping(boolean boolDumping)
    {
        isDumping = boolDumping;
    }
}
