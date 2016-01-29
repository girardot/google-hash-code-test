import input.InputReader;
import model.DataCenter;
import model.ServerOutput;
import output.Writer;
import process.SimpleProcessor;

import java.io.FileNotFoundException;
import java.util.List;

import static score.ScoreProcessor.computeScore;

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
