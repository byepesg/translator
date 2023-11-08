import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        /**********************************************************************************
        String fileName = "../yourfile.in"; // Replace with the path to your .in file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // For example, print each line
        }
        reader.close(); // Close the file when you're done
        //**********************************************************************************/
        LPP_grammarLexer lexer;
        if (args.length>0)
            lexer = new LPP_grammarLexer(CharStreams.fromFileName(args[0]));
        else
            
            lexer = new LPP_grammarLexer(CharStreams.fromStream(System.in));
        // create a buffer of tokens pulled from the lexer
                CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
                LPP_grammarParser parser = new LPP_grammarParser(tokens);
                ParseTree tree = parser.programa(); // begin parsing at init rule
         
        // Create a generic parse tree walker that can trigger callbacks
         ParseTreeWalker walker = new ParseTreeWalker();
         // Walk the tree created during the parse, trigger callbacks
        Traductor obj = new Traductor();
        walker.walk(obj, tree);
        //System.out.println("Holli"); // print a \n after translation

        System.out.println(obj.getCode());

        }
    }
