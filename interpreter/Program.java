package interpreter;

import java.util.ArrayList;
import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param //program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {

        ArrayList<LabelCode> labelList = new ArrayList<>();

        for(int i = 0; i < program.size(); i++)
        {
            if(program.get(i) instanceof LabelCode)
            {
                labelList.add((LabelCode)program.get(i));
            }
        }

        for(int i = 0; i < program.size(); i++)
        {
            ByteCode temp;
            if(program.get(i) instanceof GotoCode)
            {
                temp = program.get(i);
                for(int j = 0; j < labelList.size(); j ++)
                {
                    if(((GotoCode)temp).getLabel().equals((labelList.get(j)).getLabel()))
                    {
                        System.out.println("Goto");
                    }
                }
            }
            else if(program.get(i) instanceof FalseBranchCode)
            {
                temp = program.get(i);
                for(int j = 0; j < labelList.size(); j ++)
                {
                    if(((FalseBranchCode)temp).getLabel().equals((labelList.get(j)).getLabel()))
                    {
                        System.out.println("FalseBranch");
                    }
                }

            }
            else if(program.get(i) instanceof CallCode)
            {
                temp = program.get(i);
                for(int j = 0; j < labelList.size(); j ++)
                {
                    if(((CallCode)temp).getLabel().equals((labelList.get(j)).getLabel()))
                    {
                        System.out.println("Call");
                    }
                }

            }
        }
    }

    protected void addByteCode(ByteCode code)
    {
        program.add(code);
    }


}
