package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String label;
    private int point;

    @Override
    public void init(ArrayList<String> argument) {

        label = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

//        if(vm.popStack() == 0)
        {
//            vm.setPc(point);
        }

    }

    public String getLabel() {

        return label;
    }

    public void setPoint(int newPoint) {

        point = newPoint;
    }

}
