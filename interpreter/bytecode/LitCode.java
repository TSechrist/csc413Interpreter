package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
LitCode takes a single argument and pushes the argument onto
the top of the RunTimeStack.
 */

public class LitCode extends ByteCode {

    private int value;
    private String comment = "";

    @Override
    public void init(ArrayList<String> argument) {

        value = Integer.parseInt(argument.get(0));
        if(argument.size() > 1)
        {
            comment = argument.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.pushStack(value);
    }

    public String print(){

        return ("LIT " + value + " " + comment + "\n");
    }
}
