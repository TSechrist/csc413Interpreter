package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
GotoCode is a jump in our bytecode. It gets its address destination
during the programs resolve address and store it until executed.
 */

public class GotoCode extends ByteCode {

    private String label;
    private int point;

    @Override
    public void init(ArrayList<String> argument) {

        label = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        vm.setPc(point);
    }

    public void setPoint(int newPoint) {

        point = newPoint;
    }

    public int getPoint(){

        return point;
    }

    public String getLabel(){

        return label;
    }

    public String print(){

        return ("GOTO " + label + "\n");
    }

}
