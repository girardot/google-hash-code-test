package _2014.input;

import _2014.model.City;
import _2014.model.Descriptor;
import _2014.model.Junction;
import _2014.model.Street;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class InputReader {

    public static City read(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        String firstLine = scanner.nextLine();
        String[] fLine = firstLine.split(" ");
        Descriptor descriptor = new Descriptor(parseInt(fLine[0]), parseInt(fLine[1]), parseInt(fLine[2]), parseInt(fLine[3]), parseInt(fLine[4]));

        List<Junction> junctions = Lists.newArrayList();
        for (int i = 0; i < descriptor.junctions; i++) {
            String[] line = scanner.nextLine().split(" ");
            junctions.add(new Junction(i, parseDouble(line[0]), parseDouble(line[1])));
        }

        List<Street> streets = Lists.newArrayList();
        for (int i = 0; i < descriptor.streets; i++) {
            fLine = scanner.nextLine().split(" ");
            streets.add(new Street(junctions.get(parseInt(fLine[0])), junctions.get(parseInt(fLine[1])), parseInt(fLine[2]), parseInt(fLine[3]), parseInt(fLine[4])));
            if (parseInt(fLine[2]) == 2) {
                streets.add(new Street(junctions.get(parseInt(fLine[1])), junctions.get(parseInt(fLine[0])), parseInt(fLine[2]), parseInt(fLine[3]), parseInt(fLine[4])));
            }
        }

        for (Street street : streets) {
            for (Junction junction : junctions) {
                if (street.first.index == junction.index) {
                    junction.streets.add(street);
                }
            }
        }

        return new City(descriptor, junctions, streets);
    }

    public static void main(String[] args) throws FileNotFoundException {
        City city = read(new File("src/main/resources/cars-test.in"));
        System.out.println(city);
    }

}
