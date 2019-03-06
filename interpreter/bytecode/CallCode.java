package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String label;
    private int point;
    private String argumentsPassed = "";

    @Override
    public void init(ArrayList<String> argument) {

        label = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        argumentsPassed = vm.peekFrame();
        vm.pushReturnAddrs(vm.getPc());
        vm.setPc(point);
    }

    public String getLabel(){

        return label;
    }

    public void setPoint(int newPoint){

        point = newPoint;
    }

    public String print(){

        return ("CALL " + label + "  " + label + "(" + argumentsPassed +  ")\n");
    }
}
