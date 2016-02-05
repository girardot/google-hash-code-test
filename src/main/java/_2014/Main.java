package _2014;

import _2014.model.Car;
import _2014.model.City;
import _2014.model.Junction;
import _2014.model.Street;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static _2014.input.InputReader.read;
import static _2014.output.Writer.write;
import static _2014.process.Processor.process;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        City city = read(new File("src/main/resources/cars-test.in"));

        for (Junction junction : city.junctions) {
            System.out.println(junction.index);
            for (Street street : junction.streets) {
                System.out.println(street);
            }
        }

        System.out.println("$$$$$$$$$$$$$$$$$");

        List<Car> cars = process(city);
        write(cars);
    }
}
