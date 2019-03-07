package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
CallCode is used to call functions in our programs.
It gets its pc location resolved in the resolve
address method in program. When call is executed it will
save it's current location of pc onto the return address
stack, then set the pc to the saved location.
 */

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

        String formattedLabel = label;

        for(int i = 0; i < (label.length() - 1); i++)
        {
//            System.out.println("i: " + label.charAt(i));
            if(label.charAt(i) == '<' && label.charAt(i + 1) == '<')
            {
//                System.out.println("Inside If Statement");
                formattedLabel = label.substring(0, i);
            }
        }

        return ("CALL " + label + " " + formattedLabel + "(" + argumentsPassed +  ")\n");
    }
}
