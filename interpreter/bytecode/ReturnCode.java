package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

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
