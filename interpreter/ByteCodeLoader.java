
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.bytecode.ByteCode;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private StringTokenizer token;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {

        Program loadedProgram = new Program();
        CodeTable.init();

        try{
            while(byteSource.ready())
            {
                ArrayList<String> parsedString = new ArrayList<String>();
                token = new StringTokenizer(byteSource.readLine());
                String className = CodeTable.getClassName(token.nextToken());
                Class c = Class.forName("interpreter.bytecode." + className);
                ByteCode bc = (ByteCode)c.getDeclaredConstructor().newInstance();

                while(token.hasMoreTokens())
                {
                    parsedString.add(token.nextToken());
                }

                bc.init(parsedString);
                loadedProgram.addByteCode(bc);
            }
        }
        catch(Exception e){}

        loadedProgram.resolveAddrs();
        return loadedProgram;
    }
}
