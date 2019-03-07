package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
ByteCode is the abstract shell of all of my bytecodes.
We will use this class to create subclasses of all the
bytcodes.
 */

public abstract class ByteCode {

    public abstract void init(ArrayList<String> argument);
    public abstract void execute(VirtualMachine vm);
    public abstract String print();
}
