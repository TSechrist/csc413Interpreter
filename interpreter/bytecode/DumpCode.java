package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private boolean state;

    @Override
    public void init(ArrayList<String> argument) {

        if (argument.get(0).equals("OFF"))
        {
            state = false;
        }
        else
        {
            state = true;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setDumping(state);
    }
}
