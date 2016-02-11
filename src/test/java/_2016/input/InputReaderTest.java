package _2016.input;

import com.google.common.base.Throwables;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;


public class InputReaderTest {

    @Test
    public void should_parse_input_files() {
        String[] files = {"/busy_day.in","/mother_of_all_warehouses.in","/redundancy.in","/simple"};
        InputReader inputReader = new InputReader();


        for (String file : files) {
            try {
                assertThat(inputReader.parse(file)).isNotNull();
            } catch (FileNotFoundException e) {
                throw Throwables.propagate(e);
            }
        }


    }
}