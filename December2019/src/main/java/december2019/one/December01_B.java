package december2019.one;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class December01_B {

    static int fuelMass = 0;

    public static void main(String... args) {
        try {
            AtomicInteger total = new AtomicInteger();
            Files
                    .lines(Paths.get(December01_B.class.getClassLoader().getResource("December01.txt").getPath()))
                    .forEach(x -> {
                        fuelMass = 0;
                        total.addAndGet(calculatesTheFuel(Integer.parseInt(x)));
                    });
            System.out.println("the sum of the fuel requirements for all of the modules on your spacecraft when also taking into account the mass of the added fuel is " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculatesTheFuel(int x) {
        x = Math.round(x / 3) - 2;
        if (x >= 0) {
            fuelMass += x;
            calculatesTheFuel(x);
        }
        return fuelMass;
    }

}
