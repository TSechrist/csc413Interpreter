package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
BopCode is an extension of ByteCode that will
take the top two elements in the RunTimeStack
and perform an operation on them, and push the
result from the operation.
 */

public class BopCode extends ByteCode {

    private String operator;

    @Override
    public void init(ArrayList<String> argument) {

        operator = argument.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

        int op1 = vm.popStack();
        int op2 = vm.popStack();

        if(operator.equals("+"))
            vm.pushStack(op1 + op2);
        else if(operator.equals("-"))
            vm.pushStack(op2 - op1);
        else if(operator.equals("*"))
            vm.pushStack(op2 * op1);
        else if(operator.equals("/"))
            vm.pushStack(op2 / op1);
        else if(operator.equals("=="))
        {
            if(op2 == op1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("!="))
        {
            if(op2 == op1)
                vm.pushStack(0);
            else
                vm.pushStack(1);
        }
        else if(operator.equals("<"))
        {
            if(op2 < op1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals(">"))
        {
            if(op2 > op1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("<=")) {
            if (op2 <= op1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals(">="))
        {
            if(op2 >= op1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("|"))
        {
            if(op2 == 1 || op1 == 1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
        else if(operator.equals("&"))
        {
            if(op2 * op1 == 1)
                vm.pushStack(1);
            else
                vm.pushStack(0);
        }
    }

    public String print(){

        return ("BOP " + operator + "\n");
    }

}

