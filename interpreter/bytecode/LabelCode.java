package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String label;
    private int point;

    @Override
    public void init(ArrayList<String> argument) {

        label = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public String getLabel(){

        return label;
    }

    public int getPoint() {

        return point;
    }

    public void setPoint(int newPoint){

        point = newPoint;
    }

    public String print(){

        return ("LABEL " + label + "\n");
    }
}
