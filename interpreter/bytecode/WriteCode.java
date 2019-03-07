package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
WriteCode will display the top of the RunTimeStack to the
console.
 */

public class WriteCode extends ByteCode {

    @Override
    public void init(ArrayList<String> argument) {

    }

    @Override
    public void execute(VirtualMachine vm) {

        System.out.println(vm.peekStack());
    }

    public String print(){

        return ("WRITE\n");
    }
}
