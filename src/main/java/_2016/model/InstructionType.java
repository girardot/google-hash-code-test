package _2016.model;

public enum InstructionType {

    LOAD('L'), DELIVER('D');

    private char l;

    InstructionType(char l) {
        this.l = l;
    }

    public char getL() {
        return l;
    }
}
