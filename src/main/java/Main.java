import input.InputReader;
import model.DataCenter;
import model.ServerOutput;
import process.SimpleProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

   public  static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        DataCenter dataCenter = inputReader.parse("C:\\Users\\juju\\Dropbox\\code\\google-hash-code-test\\src\\main\\resources\\dc.in");
        System.out.println(dataCenter);

       SimpleProcessor simpleProcessor = new SimpleProcessor();

       List<ServerOutput> process = simpleProcessor.process(dataCenter);
       System.out.println(process);

   }
}
