package interpreter;

import java.util.Stack;
import interpreter.bytecode.*;

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
        //Starting the virtual machine with it's starting stacks and pc
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        pc = 0;

        //This will run until you run into a halt code
        while(isRunning)
        {
            ByteCode code = program.getCode(pc);
            System.out.println(program.getCode(pc) + " " + pc);
            code.execute(this);
            pc++;
        }

        System.out.println("Frame Size: " + runStack.getFrameSize());

        for(int i = 0; i < runStack.size(); i++)
        {
            System.out.println(runStack.pop());
        }

    }

    public void setRunning(boolean boolRunning) {

        isRunning = boolRunning;
    }
    public void setDumping(boolean boolDumping) {

        isDumping = boolDumping;
    }

    public int getPc() {

        return pc;
    }
    public void setPc(int set) {

        pc = set;
    }

    public int popReturnAddrs() {

        return (int)returnAddrs.pop();
    }
    public void pushReturnAddrs(int addressGiven) {

        returnAddrs.push(addressGiven);
    }

    public int popStack() {

        return runStack.pop();
    }

    public int peekStack() {

        return runStack.peek();
    }

    public void pushStack(int value) {

        runStack.push(value);
    }

    public void newFrame(int value){

        runStack.newFrame(value);
    }

    public void popFrame(){

        runStack.popFrame();
    }

}
