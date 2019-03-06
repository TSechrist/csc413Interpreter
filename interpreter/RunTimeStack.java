package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public int pop() {

        int temp = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        return temp;
    }

    public int peek() {

        if(runTimeStack.size() > 0)
        {
            return runTimeStack.get(runTimeStack.size() - 1);
        }
        else
        {
            return runTimeStack.get(0);
        }
    }

    public int push(int num) {

        runTimeStack.add(num);
        return peek();
    }

    public int size() {

        return runTimeStack.size();
    }

    public int getFrameSize() {

        int size = 0;
        Iterator i = framePointer.iterator();
        while(i.hasNext())
        {
            size++;
            i.next();
        }
        return size;
    }

    public void newFrame(int value) {

        framePointer.add((runTimeStack.size()) - value);
    }

    public void popFrame(){

        int temp = runTimeStack.get(runTimeStack.size() - 1);
        while(runTimeStack.size() != framePointer.peek())
        {
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        runTimeStack.add(temp);
        framePointer.pop();
    }

    public int storeStack(int value) {

        int topPointer = framePointer.peek();
        runTimeStack.set((value + topPointer), pop());
        return topPointer;
    }

    public int loadStack(int value) {

        int temp = runTimeStack.get(framePointer.peek() + value);
        runTimeStack.add(temp);
        return temp;
    }

    public void dump()
    {

        ArrayList<Integer> cloneStack;
        cloneStack = (ArrayList)runTimeStack.clone();
        ArrayList holdArray[] = new ArrayList[framePointer.size()];


        for(int i = framePointer.size(); i > 0; i--)
        {
            holdArray[i - 1] = new ArrayList<>();
            int front = framePointer.get(i - 1);
            int size = cloneStack.size();

            for(int j = front; j < size; j++)
            {
                holdArray[i - 1].add(cloneStack.remove(front));
            }
        }

        for(int i = 0; i < framePointer.size(); i++)
        {
            System.out.print(holdArray[i].toString());
        }

        System.out.println();
    }

}
