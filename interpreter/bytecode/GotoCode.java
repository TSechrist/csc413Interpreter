package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

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
        System.out.println("Goto point: " + point);
    }

    public int getPoint(){

        return point;
    }

    public String getLabel(){

        return label;
    }

}
