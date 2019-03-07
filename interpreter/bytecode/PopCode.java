package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
PopCode will ask the VM to pop the top of the runtimestack.
It will ask for it to pop as many times as given in the
argument.
 */

public class PopCode extends ByteCode {

    private int value;

    @Override
    public void init(ArrayList<String> argument) {

        value = Integer.parseInt(argument.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {

        int size = vm.size();
        if(value < size)
        {
            size = value;
        }

        for (int i = 0; i < size; i++)
        {
            vm.popStack();
        }
    }

    public String print(){

        return ("POP " + value + "\n");
    }
}
