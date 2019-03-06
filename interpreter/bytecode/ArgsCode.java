package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int value;

    @Override
    public void init(ArrayList<String> argument) {

        value = Integer.parseInt(argument.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.newFrame(value);
    }

    public String print(){

        return ("ARGS " + value + "\n");
    }

}
