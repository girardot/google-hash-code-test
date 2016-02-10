package _2016;

import _2016.input.InputReader;
import _2016.model.Model;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;

import java.io.FileNotFoundException;
import java.util.List;

import static _2016.score.ScoreProcessor.computeScore;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        Model model = inputReader.parse("empty");
        System.out.println(model);

        SimpleProcessor simpleProcessor = new SimpleProcessor();

        List<Model> output = simpleProcessor.process(model);
        System.out.println("Score => " + computeScore(model, output));
        Writer writer = new Writer();
        writer.write(output);
    }

}
