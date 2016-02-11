package _2016;

import _2016.input.InputReader;
import _2016.model.Input;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;

import java.io.FileNotFoundException;
import java.util.List;

import static _2016.score.ScoreProcessor.computeScore;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        Input input = inputReader.parse("empty");
        System.out.println(input);

        SimpleProcessor simpleProcessor = new SimpleProcessor();

        List<Input> output = simpleProcessor.process(input);
        System.out.println("Score => " + computeScore(input, output));
        Writer writer = new Writer();
        writer.write(output);
    }

}
