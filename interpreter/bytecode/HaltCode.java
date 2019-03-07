package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
HaltCode is only used at the end of our program. It will set
the VM running variable to false and stop the virtual machine
from executing more bytecodes.
 */

public class HaltCode extends ByteCode {

    @Override
    public void init(ArrayList<String> argument) {

    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setRunning(false);

    }

    public String print(){

        return ("HALT\n");
    }
}
