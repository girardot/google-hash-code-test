import input.InputReader;
import model.DataCenter;

import java.io.FileNotFoundException;

public class Main {

   public  static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader();
        DataCenter dataCenter = inputReader.parse("C:\\Users\\juju\\Dropbox\\code\\google-hash-code-test\\src\\main\\resources\\dc.in");
        System.out.println(dataCenter);
    }
}
