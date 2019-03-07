package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*ReturnCode is the return from a function. It
will pop the top return address on the address
stack and set the pc to that location. It will then pop the
frame.
 */

public class ReturnCode extends ByteCode {

    private String comment = "";

    @Override
    public void init(ArrayList<String> argument) {

        if(argument.size() > 0)
        {
            comment = argument.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setPc(vm.popReturnAddrs());
        vm.popFrame();
    }

    public String print(){

        return ("RETURN "+ comment + "\n");
    }
}
