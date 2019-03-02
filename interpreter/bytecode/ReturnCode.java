package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {

    @Override
    public void init(ArrayList<String> argument) {

    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setPc(vm.popReturnAddrs());
        vm.popFrame();
    }
}
