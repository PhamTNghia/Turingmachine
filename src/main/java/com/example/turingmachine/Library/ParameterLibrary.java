package com.example.turingmachine.Library;

public class ParameterLibrary {
    public static int initializedCell =30;
    public static int speed=1000;

    public static String[] choiceOfType={"1 Tape", "2 Tape","3 Tape","MultiTracking3Tape", "Non_Deterministic"};

    public enum ExampleList{
        ONE_TAPE(new String[]{"Decimal To Binary"}),
        TWO_TAPE(new String[]{"Binary Palindrome"}),
        THREE_TAPE(new String[]{"Binary Addition"}),
        MULTI_TRACKING_3_TAPE(new String[]{""}),
        NON_DETERMINISTIC(new String[]{"Even length a"});

        private final String[] exampleList;

        ExampleList(String[] exampleList) {
            this.exampleList = exampleList;
        }

        public String[] getExampleList() {
            return exampleList;
        }
    }
}
