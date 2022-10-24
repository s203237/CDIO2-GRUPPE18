import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TerningTest {

    @org.junit.jupiter.api.Test
    void roll() {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;

        int dice1;

        for (int i = 0; i <= 10000; i++) {
            Random rand = new Random();
            dice1 = rand.nextInt(6) + 1;
            if (dice1 == 1) {
                counter1++;
            }
            if (dice1 == 2) {
                counter2++;
            }
            if (dice1 == 3) {
                counter3++;
            }
            if (dice1 == 4) {
                counter4++;
            }
            if (dice1 == 5) {
                counter5++;
            }
            if (dice1 == 6) {
                counter6++;
            }
        }

        System.out.println("Antal 1'ere: " + counter1);
        System.out.println("Antal 2'ere: " + counter2);
        System.out.println("Antal 3'ere: " + counter3);
        System.out.println("Antal 4'ere: " + counter4);
        System.out.println("Antal 5'ere: " + counter5);
        System.out.println("Antal 6'ere: " + counter6);
    }
}