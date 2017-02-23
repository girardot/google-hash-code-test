package _2017.input;

import _2017.model.World;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputReaderTest {


    @Test
    public void should_parse_test() throws Exception {
        World world = new InputReader().parse("inputtest");


        System.out.println(world);
    }
}