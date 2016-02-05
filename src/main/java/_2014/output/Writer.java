package _2014.output;

import _2014.model.Car;
import _2014.model.Junction;

import java.util.List;

public class Writer {

    public static void write(List<Car> cars) {
        System.out.println(cars.size());
        for (Car car : cars) {
            System.out.println(car.junctions.size());
            for (Junction junction : car.junctions) {
                System.out.println(junction.index);
            }
        }
    }
}
