package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    private String input;

    @Override
    public void init(ArrayList<String> argument) {

    }

    @Override
    public void execute(VirtualMachine vm) {

        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a number");
        input = stdin.nextLine();
        try{
            int value = Integer.parseInt(input);
            vm.pushStack(value);
        }
        catch(Exception E){
            System.out.println("Must input a number");
        }

    }
}
