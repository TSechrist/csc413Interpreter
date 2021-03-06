package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {

    private int value;
    private String comment;

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

        vm.storeStack(value);
    }
    public String print(){

        return ("STORE " + value + " " + comment + "\n");
    }
}
