package _2015;

import _2015.input.InputReader;
import _2015.model.DataCenter;
import _2015.model.ServerOutput;
import _2015.output.Writer;
import _2015.process.SimpleProcessor;

import java.io.FileNotFoundException;
import java.util.List;

import static _2015.score.ScoreProcessor.computeScore;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        DataCenter dataCenter = inputReader.parse("src/main/resources/dc-test.in");
        System.out.println(dataCenter);

        SimpleProcessor simpleProcessor = new SimpleProcessor();

        List<ServerOutput> serverOutputs = simpleProcessor.process(dataCenter);
        System.out.println("Score => " + computeScore(dataCenter, serverOutputs));
        Writer writer = new Writer();
        writer.write(serverOutputs);
    }

}
