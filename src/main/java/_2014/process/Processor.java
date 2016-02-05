package _2014.process;

import _2014.model.Car;
import _2014.model.City;
import _2014.model.Street;
import com.google.common.collect.Lists;

import java.util.List;

public class Processor {

    public static List<Car> process(City city) {

        List<Car> cars = Lists.newArrayList();

        for (int i = 0; i < city.descriptor.cars; i++) {
            cars.add(new Car(city.descriptor.seconds, city.junctions.get(0)));
        }

        boolean browseResult = false;
        do {
            for (Car car : cars) {
                Street street = chooseStreet(car);
                browseResult = car.browse(street);
            }
        } while (browseResult);

        return cars;
    }

    private static Street chooseStreet(Car car) {
        List<Street> streets = car.lastJunction.streets;
        int v = (int) (Math.random() * streets.size());
        return streets.get(v);
    }

}
