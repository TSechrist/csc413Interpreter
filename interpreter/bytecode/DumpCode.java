package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
DumpCode is for setting the dump state of the VM.
It will store its argument and set the VM to on
or off.
 */

public class DumpCode extends ByteCode {

    private boolean state;

    @Override
    public void init(ArrayList<String> argument) {

        if (argument.get(0).equals("ON"))
        {
            state = true;
        }
        else
        {
            state = false;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setDumping(state);
    }

    public String print(){

        return ("");
    }
}
