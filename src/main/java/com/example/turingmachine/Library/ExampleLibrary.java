package com.example.turingmachine.Library;

public class ExampleLibrary {
    public enum Example{
        DECIMAL_TO_BI(new String("name: Decimal to binary\n" +
                "init: qinit\n" +
                "accept: qfin\n" +
                "\n" +
                "qinit,0\n" +
                "qinit,0,>\n" +
                " \n" +
                "qinit,1\n" +
                "qinit,1,>\n" +
                " \n" +
                "qinit,2\n" +
                "qinit,2,>\n" +
                " \n" +
                "qinit,3\n" +
                "qinit,3,>\n" +
                " \n" +
                "qinit,4\n" +
                "qinit,4,>\n" +
                " \n" +
                "qinit,5\n" +
                "qinit,5,>\n" +
                " \n" +
                "qinit,6\n" +
                "qinit,6,>\n" +
                " \n" +
                "qinit,7\n" +
                "qinit,7,>\n" +
                " \n" +
                "qinit,8\n" +
                "qinit,8,>\n" +
                " \n" +
                "qinit,9\n" +
                "qinit,9,>\n" +
                " \n" +
                "qinit,_\n" +
                "halve,0,<\n" +
                " \n" +
                "// Halve and go to addHalf to add the goBack\n" +
                "halve,0\n" +
                "halve,0,<\n" +
                " \n" +
                "halve,1\n" +
                "addHalf,0,>\n" +
                " \n" +
                "halve,2\n" +
                "halve,1,<\n" +
                " \n" +
                "halve,3\n" +
                "addHalf,1,>\n" +
                " \n" +
                "halve,4\n" +
                "halve,2,<\n" +
                " \n" +
                "halve,5\n" +
                "addHalf,2,>\n" +
                " \n" +
                "halve,6\n" +
                "halve,3,<\n" +
                " \n" +
                "halve,7\n" +
                "addHalf,3,>\n" +
                " \n" +
                "halve,8\n" +
                "halve,4,<\n" +
                " \n" +
                "halve,9\n" +
                "addHalf,4,>\n" +
                " \n" +
                "// Add 0.5 to the right\n" +
                "addHalf,0\n" +
                "jump,5,<\n" +
                " \n" +
                "addHalf,1\n" +
                "jump,6,<\n" +
                " \n" +
                "addHalf,2\n" +
                "jump,7,<\n" +
                " \n" +
                "addHalf,3\n" +
                "jump,8,<\n" +
                " \n" +
                "addHalf,4\n" +
                "jump,9,<\n" +
                " \n" +
                "// Jump back\n" +
                "jump,0\n" +
                "halve,0,<\n" +
                " \n" +
                "jump,1\n" +
                "halve,1,<\n" +
                " \n" +
                "jump,2\n" +
                "halve,2,<\n" +
                " \n" +
                "jump,3\n" +
                "halve,3,<\n" +
                " \n" +
                "jump,4\n" +
                "halve,4,<\n" +
                " \n" +
                "// If we halved successfully, we first remove the zero if there is one and then we go back\n" +
                "halve,_\n" +
                "removezero,_,>\n" +
                " \n" +
                "removezero,0\n" +
                "removezero,_,>\n" +
                " \n" +
                "removezero,1\n" +
                "goBack,1,>\n" +
                " \n" +
                "removezero,2\n" +
                "goBack,2,>\n" +
                " \n" +
                "removezero,3\n" +
                "goBack,3,>\n" +
                " \n" +
                "removezero,4\n" +
                "goBack,4,>\n" +
                " \n" +
                "removezero,5\n" +
                "goBack,5,>\n" +
                " \n" +
                "removezero,6\n" +
                "goBack,6,>\n" +
                " \n" +
                "removezero,7\n" +
                "goBack,7,>\n" +
                " \n" +
                "removezero,8\n" +
                "goBack,8,>\n" +
                " \n" +
                "removezero,9\n" +
                "goBack,9,>\n" +
                " \n" +
                "// qfinished\n" +
                "removezero,_\n" +
                "qfin,_,>\n" +
                " \n" +
                "// normal goBack\n" +
                "goBack,0\n" +
                "goBack,0,>\n" +
                " \n" +
                "goBack,1\n" +
                "goBack,1,>\n" +
                " \n" +
                "goBack,2\n" +
                "goBack,2,>\n" +
                " \n" +
                "goBack,3\n" +
                "goBack,3,>\n" +
                " \n" +
                "goBack,4\n" +
                "goBack,4,>\n" +
                " \n" +
                "goBack,5\n" +
                "goBack,5,>\n" +
                " \n" +
                "goBack,6\n" +
                "goBack,6,>\n" +
                " \n" +
                "goBack,7\n" +
                "goBack,7,>\n" +
                " \n" +
                "goBack,8\n" +
                "goBack,8,>\n" +
                " \n" +
                "goBack,9\n" +
                "goBack,9,>\n" +
                " \n" +
                "// rest\n" +
                "goBack,_\n" +
                "rest,_,<\n" +
                " \n" +
                "rest,0\n" +
                "rest0,_,>\n" +
                " \n" +
                "rest0,_\n" +
                "setrest0,_,>\n" +
                " \n" +
                "rest,5\n" +
                "rest1,_,>\n" +
                " \n" +
                "rest1,_\n" +
                "setrest1,_,>\n" +
                " \n" +
                "setrest0,0\n" +
                "setrest0,0,>\n" +
                " \n" +
                "setrest0,1\n" +
                "setrest0,1,>\n" +
                " \n" +
                "setrest1,0\n" +
                "setrest1,0,>\n" +
                " \n" +
                "setrest1,1\n" +
                "setrest1,1,>\n" +
                " \n" +
                "setrest0,_\n" +
                "continue,0,<\n" +
                " \n" +
                "setrest1,_\n" +
                "continue,1,<\n" +
                " \n" +
                "// continue\n" +
                "continue,0\n" +
                "continue,0,<\n" +
                " \n" +
                "continue,1\n" +
                "continue,1,<\n" +
                " \n" +
                "continue,_\n" +
                "continue2,_,<\n" +
                " \n" +
                "// delimiter\n" +
                "continue2,_\n" +
                "halve,0,<")),
        BINARY_PALINDROME(new String(
                "name: Fast binary palindrome\n" +
                "init: qCopy\n" +
                "accept: qAccept\n" +
                "\n" +
                "qCopy,0,_\n" +
                "qCopy,0,0,>,>\n" +
                "\n" +
                "qCopy,1,_\n" +
                "qCopy,1,1,>,>\n" +
                "\n" +
                "qCopy,_,_\n" +
                "qReturn,_,_,-,<\n" +
                "\n" +
                "qReturn,_,0\n" +
                "qReturn,_,0,-,<\n" +
                "\n" +
                "qReturn,_,1\n" +
                "qReturn,_,1,-,<\n" +
                "\n" +
                "qReturn,_,_\n" +
                "qTest,_,_,<,>\n" +
                "\n" +
                "qTest,0,0\n" +
                "qTest,0,0,<,>\n" +
                "\n" +
                "qTest,1,1\n" +
                "qTest,1,1,<,>\n" +
                "\n" +
                "qTest,_,_\n" +
                "qAccept,_,_,-,-")),
        BINARY_ADD(new String("// Input: a#b (a and b are binary numbers)\n" +
                "// Ouput: a+b\n" +
                "// Example: 1011#10 outputs 1101\n" +
                "//\n" +
                "// Binary Addition Algorithm\n" +
                "// for Turing Machine Simulator \n" +
                "// turingmachinesimulator.com\n" +
                "// By Jose Antonio Matte\n" +
                "\n" +
                "name: Binary addition\n" +
                "init: q0\n" +
                "accept: q5\n" +
                "\n" +
                "q0,0,_,_\n" +
                "q0,0,_,_,>,-,-\n" +
                "\n" +
                "q0,1,_,_\n" +
                "q0,1,_,_,>,-,-\n" +
                "\n" +
                "q0,#,_,_\n" +
                "q1,_,_,_,>,-,-\n" +
                "\n" +
                "q1,0,_,_\n" +
                "q1,_,0,_,>,>,-\n" +
                "\n" +
                "q1,1,_,_\n" +
                "q1,_,1,_,>,>,-\n" +
                "\n" +
                "q1,_,_,_\n" +
                "q2,_,_,_,<,<,-\n" +
                "\n" +
                "q2,_,0,_\n" +
                "q2,_,0,_,<,-,-\n" +
                "\n" +
                "q2,_,1,_\n" +
                "q2,_,1,_,<,-,-\n" +
                "\n" +
                "q2,1,0,_\n" +
                "q3,1,0,_,-,-,-\n" +
                "\n" +
                "q2,1,1,_\n" +
                "q3,1,1,_,-,-,-\n" +
                "\n" +
                "q2,0,1,_\n" +
                "q3,0,1,_,-,-,-\n" +
                "\n" +
                "q2,0,0,_\n" +
                "q3,0,0,_,-,-,-\n" +
                "\n" +
                "q3,1,0,_\n" +
                "q3,1,0,1,<,<,<\n" +
                "\n" +
                "q3,0,1,_\n" +
                "q3,0,1,1,<,<,<\n" +
                "\n" +
                "q3,0,0,_\n" +
                "q3,0,0,0,<,<,<\n" +
                "\n" +
                "q3,1,1,_\n" +
                "q4,1,1,0,<,<,<\n" +
                "\n" +
                "q3,_,_,_\n" +
                "q5,_,_,_,-,-,-\n" +
                "\n" +
                "q3,1,_,_\n" +
                "q3,1,_,1,<,<,<\n" +
                "\n" +
                "q3,0,_,_\n" +
                "q3,0,_,0,<,<,<\n" +
                "\n" +
                "q3,_,1,_\n" +
                "q3,_,1,1,<,<,<\n" +
                "\n" +
                "q3,_,0,_\n" +
                "q3,_,0,0,<,<,<\n" +
                "\n" +
                "q4,0,0,_\n" +
                "q3,0,0,1,<,<,<\n" +
                "\n" +
                "q4,0,1,_\n" +
                "q4,0,1,0,<,<,<\n" +
                "\n" +
                "q4,1,0,_\n" +
                "q4,1,0,0,<,<,<\n" +
                "\n" +
                "q4,1,1,_\n" +
                "q4,1,1,1,<,<,<\n" +
                "\n" +
                "q4,_,0,_\n" +
                "q3,_,0,1,<,<,<\n" +
                "\n" +
                "q4,_,1,_\n" +
                "q4,_,1,0,<,<,<\n" +
                "\n" +
                "q4,1,_,_\n" +
                "q4,1,_,0,<,<,<\n" +
                "\n" +
                "q4,0,_,_\n" +
                "q3,0,_,1,<,<,<\n" +
                "\n" +
                "q4,_,_,_\n" +
                "q5,_,_,1,-,-,-")),
        EVEN_LENGTH_A(new String(
                "name: Even_length_a\n" +
                "init: q0\n" +
                "accept: qAccept\n" +
                "\n" +
                "q0,a\n" +
                "q1,>\n" +
                "q3,>\n" +
                "\n" +
                "q0,_\n" +
                "qAccept,>\n" +
                "\n" +
                "q1,a\n" +
                "q2,>\n" +
                "\n" +
                "q1,_\n" +
                "qReject,>\n" +
                "\n" +
                "q2,a\n" +
                "q1,>\n" +
                "\n" +
                "q2,_\n" +
                "qAccept,>\n" +
                "\n" +
                "q3,_\n" +
                "qAccept,>\n"
                ));

        private final String example;

        Example(String example) {
            this.example = example;
        }

        public String getExample() {
            return example;
        }
    }
}
