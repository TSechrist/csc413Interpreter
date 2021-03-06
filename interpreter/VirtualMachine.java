package interpreter;

import java.util.Stack;
import interpreter.bytecode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning = true;
    private boolean isDumping = true;

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
            code.execute(this);
            pc++;
            if(isDumping)
            {
                if(!(code instanceof DumpCode)) //If dumping is on I still don't want to print a DumpCode
                {
                    System.out.print(code.print());
                    runStack.dump();
                }
            }
        }

    }

    public void setRunning(boolean boolRunning) {

        isRunning = boolRunning;
    }
    public void setDumping(boolean boolDumping) {

        isDumping = boolDumping;
    }

    //These will change the pc order of our program.
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

    public String peekFrame(){

        return runStack.peekFrame();
    }

    public int storeStack(int value){

        return runStack.storeStack(value);
    }

    public int loadStack(int value){

        return runStack.loadStack(value);
    }

    public int size(){

        return runStack.size();
    }
}
