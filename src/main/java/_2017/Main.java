package _2017;

import _2017.input.InputReader;
import _2017.model.World;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        String[] fileNames = {"file.in"};
        for (String fileName : fileNames) {
            World world = inputReader.parse("/" + fileName);

        }

    }

}