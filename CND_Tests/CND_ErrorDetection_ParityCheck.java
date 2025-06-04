package CND_Tests;

import java.util.Scanner;

public class CND_ErrorDetection_ParityCheck {

    static Scanner sc = new Scanner(System.in);
    static String userMessage;

    public static void main(String[] args) {

        System.out.print("Enter the message : ");
        userMessage = sc.nextLine();

        String[] encodedData = sendData(userMessage);

        // Optionally simulate a fault
        System.out.print("Interrupt Message ? (Yes/No) : ");
        char interrupt = sc.nextLine().toUpperCase().charAt(0);
        if (interrupt == 'Y') {
            System.out.printf("Which character u want to disturb (0 - %d) : ", userMessage.length() - 1);
            int roomNum = sc.nextInt();
            encodedData[roomNum] = "01";
        } else
            System.out.println("Message not interrupted.");

        receiveData(encodedData);
    }

    public static String[] sendData(String userData) {
        System.out.println("User data : " + userData);

        // call endcoding function
        String[] encodedData = partialCheck_encoding(userData);

        // printing console
        System.out.print("sending data . . . ");
        for (String s : encodedData)
            System.out.print(s);
        System.out.println();

        return encodedData;
    }

    public static String[] partialCheck_encoding(String userString) {
        String[] encodedData = new String[userString.length()];

        // looping String to encode each char inside the string
        for (int i = 0; i < userString.length(); i++) {

            // Use either of the two functions here
            // userArr[i] = particalCheck_encode_char(userString.charAt(i));
            encodedData[i] = my_particalCheck_encode_char(userString.charAt(i));
            // encoded and insert into encodedDate[currentRoom]
        }

        return encodedData;
    }

    public static String my_particalCheck_encode_char(char ch) {
        // char to Binary a -> 11000011
        String userBinary = Integer.toBinaryString(ch);

        // Count 1s in Binary String
        int oneCount = 0;
        // making "11000011".toCharArray() -> [1,1,0,0,0,0,1,1]
        for (char bit : userBinary.toCharArray()) {
            // so i can count 1s now.
            if (bit == '1')
                oneCount++;
        }

        // Add parity bit to the last
        if (oneCount % 2 == 0)
            return userBinary + "0"; // if 1 count is even, pad 0
        else
            return userBinary + "1"; // if 1 count is not even, pad 1
    }

    // Same function as above, but different style
    public static String particalCheck_encode_char(char ch) {
        // Convert char -> ASCII binary, pad to 8 bits
        String binary = String.format("%8s", Integer.toBinaryString(ch)).replace(' ', '0');
        System.out.println(binary);

        // Count 1s
        int ones = 0;

        for (char b : binary.toCharArray()) {
            if (b == '1')
                ones++;
        }
        System.out.println(ones);

        // Add parity
        String parityBit = (ones % 2 == 0) ? "0" : "1";
        System.out.println(binary + parityBit);
        return binary + parityBit;
    }

    public static void receiveData(String[] encodedData) {
        // just printing received Binary bits
        System.out.print("received data . . . ");
        for (String s : encodedData)
            System.out.print(s);
        System.out.println();

        // Calling decoding function
        String[] orginalMessageArray = partialCheck_decoding(encodedData);

        // Final Stage of the whole task
        // printing the decoded original message.
        System.out.print("Received data : ");
        for (String s : orginalMessageArray)
            System.out.print(s);
        System.out.println();
    }

    // Decoding Funtion : this function will do the opposite of Encoding function
    public static String[] partialCheck_decoding(String[] encodedData) {

        String[] orginalMessage = new String[encodedData.length];

        for (int i = 0; i < encodedData.length; i++) {
            String currentData = encodedData[i];

            // Count 1s
            int ones = 0;
            for (char c : currentData.toCharArray()) {
                if (c == '1')
                    ones++;
            }

            // Check parity
            if (ones % 2 == 0) {
                // Remove parity bit
                String binaryWithoutParity = currentData.substring(0, currentData.length() - 1);

                // Convert binary to char
                int ascii = Integer.parseInt(binaryWithoutParity, 2); // binary -> decimal(ASCII)
                orginalMessage[i] = String.valueOf((char) ascii); // ASCII -> char
            } else {

                System.out.println("Message interrupted!!!");
                // orginalMessage[i] = "";

                // Optionally:

                // request the lost bit
                String[] rqB = requestFaultBit(i);

                // decode the bit by recursive function
                orginalMessage[i] = partialCheck_decoding(rqB)[0];

            }
        }

        return orginalMessage;
    }

    // requesting the lost/disturbed bit function
    public static String[] requestFaultBit(int i) {
        // get char direct from userMessage
        // then send it with sendData function
        String[] requestedBit = sendData(String.valueOf(userMessage.charAt(i)));
        System.out.println("Resending interrupted bit..." + requestedBit[0]);

        // this is encoded BitString got from sendData function
        return requestedBit;
    }
}
