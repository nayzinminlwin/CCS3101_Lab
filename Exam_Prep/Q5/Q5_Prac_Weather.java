package Q5;

//  weather‐monitoring application needs a Java console program that reads an integer N from the user followed by N daily records 
// (each record consists of a UTF‑8 date string in ISO format, a double temperature in Celsius, a double humidity percentage, 
// and a UTF‑8 condition description), writes all records in sequence to weather.dat using DataOutputStream, 
// then reads them back with DataInputStream, 
// identifies and prints the single day with the highest temperature 
// and the single day with the highest humidity (displaying their dates and values).

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Q5_Prac_Weather {
    public static void main(String[] args) {
        WriteBinary();
        ReadBinary();
    }

    public static void WriteBinary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Weather data for how many days ? : ");
        int days = sc.nextInt();

        try (DataOutputStream dOut = new DataOutputStream(new FileOutputStream("Weather.dat"))) {
            String date, condition;
            double temp, humid;
            for (int i = 1; i <= days; i++) {
                date = LocalDateTime.now().toString();
                temp = (Math.random() * 60);
                humid = (Math.random() * 100);
                condition = (int) (Math.random() * 2) == 0 ? "Good" : "Bad";

                System.out.printf("\nInserted into File!!\nDate: %s\nTempearture: %s\nHumidity: %s\nCondition: %s\n",
                        date, temp, humid, condition);

                dOut.writeUTF(date);
                dOut.writeDouble(temp);
                dOut.writeDouble(humid);
                dOut.writeUTF(condition);
            }
            dOut.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        sc.close();
    }

    public static void ReadBinary() {

        try (DataInputStream dIn = new DataInputStream(new FileInputStream("Weather.dat"))) {
            String[] currentWeather = new String[4];
            String[] highestTempWeather = new String[4];
            String[] highestHumidWeather = new String[4];
            double highestTemp = 0;
            double hightestHumid = 0;

            while (dIn.available() != 0) {
                currentWeather[0] = dIn.readUTF();

                double cTemp = dIn.readDouble();
                currentWeather[1] = "" + cTemp;
                double cHumid = dIn.readDouble();
                currentWeather[2] = "" + cHumid;

                currentWeather[3] = dIn.readUTF();

                if (cTemp > highestTemp) {
                    highestTemp = cTemp;
                    highestTempWeather = Arrays.copyOf(currentWeather, currentWeather.length);
                }

                if (cHumid > hightestHumid) {
                    hightestHumid = cHumid;
                    highestHumidWeather = Arrays.copyOf(currentWeather, currentWeather.length);
                }
            }

            System.out.printf("\nHighest Temperature Weather\nDate: %s\nTempearture: %s\nHumidity: %s\nCondition: %s\n",
                    highestTempWeather[0], highestTempWeather[1], highestTempWeather[2], highestTempWeather[3]);

            System.out.printf("\nMost Humid Weather\nDate: %s\nTempearture: %s\nHumidity: %s\nCondition: %s\n",
                    highestHumidWeather[0], highestHumidWeather[1], highestHumidWeather[2], highestHumidWeather[3]);

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}