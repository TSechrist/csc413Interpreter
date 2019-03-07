package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
FalseBranchCode is our conditional tool for this language.
It will jump to the saved address that he has stored if
the top of the RunTimeStack is 0, otherwise it will do nothing else.
 */

public class FalseBranchCode extends ByteCode {

    private String label;
    private int point;

    @Override
    public void init(ArrayList<String> argument) {

        label = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        if(vm.popStack() == 0)
        {
            vm.setPc(point);
        }

    }

    public String getLabel() {

        return label;
    }

    public void setPoint(int newPoint) {

        point = newPoint;
    }

    public String print(){

        return ("FALSEBRANCH " + label + "\n");
    }
}
