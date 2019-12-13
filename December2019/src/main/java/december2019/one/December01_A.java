package december2019.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class December01_A {

    public static void main(String... args) {
        try {
            int sum = Files
                    .lines(Paths.get(December01_A.class.getClassLoader().getResource("December01.txt").getPath()))
                    .map(x -> Math.round(Integer.parseInt(x) / 3) - 2)
                    .mapToInt(Integer::intValue).sum();

            System.out.println("the sum of the fuel requirements for all of the modules on your spacecraft is " + sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
