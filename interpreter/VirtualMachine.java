package interpreter;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {

    }
}
