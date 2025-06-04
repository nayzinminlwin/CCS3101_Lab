package CND_Tests;

public class CND_anotherTest_ErrorDetection {

    public static void main(String[] args) {
        String userData = "Hello !";

        // send userData via sendData function, it will return the encodedBinary data
        String[] encodedData = sendData(userData);
        System.out.println();

        // toggle following cmt to see message interrupted.
        // encodedData[4] = "0";

        // decoding function ; fromt binary back to original msg
        receiveData(encodedData);

    }

    public static String[] sendData(String userData) {
        System.out.println("User Data : " + userData);

        // encoded data array will be same size with userData length
        // if user data : "Hi" ;
        // encodedData will be : ["10010001101001","10010001101001"]
        // one array room for one char each.
        String[] encodedData = new String[userData.length()];

        // looping
        for (int i = 0; i < encodedData.length; i++) {
            // in loops ;
            // For visualization and validation, try to print what u wanna know/see

            char aChar = userData.charAt(i);
            // System.out.println(aChar); // current char

            // the ultimate function doing the task
            // current char -> binaryString
            String binaryData = Integer.toBinaryString(aChar);
            // System.out.println(binaryData);

            encodedData[i] = binaryData; // masuk binaryData into current room of encodedData Array
        }

        // the following line is just printing sexy 0 and 1s.
        System.out.print("Sending data . . ." + String.join("", encodedData));

        // return encodedData, so main method can fetch it;
        return encodedData;
    }

    // this function will do the reverse/upsideDown what sendData function did
    public static void receiveData(String[] encodedData) {

        // just sexy printing
        System.out.println("Received Bits . . ." + String.join("", encodedData));

        // the translated message from binary to char will added into this
        // originalMessage variable
        String originalMessage = "";

        // looping to translate each binary inside encodedData to char
        // Each binaryCode -> char
        for (int i = 0; i < encodedData.length; i++) {
            String currentRoom = encodedData[i];

            // // parseInt function will change binary to decimal
            // int myAscii = Integer.parseInt(currentRoom, 2);
            // System.out.println("Current ASCII : " + myAscii);
            // // 2 in second parameter mean Binary, if 16, it is saying HEXA

            // // typecasting ASCII int to char // java know itself
            // char myChar = (char) myAscii;

            // the two lines commented above, written in one line.
            char myChar = (char) Integer.parseInt(currentRoom, 2);

            // System.out.println("Current Char : " + myChar);

            // adding char to string is simple
            // originalMessage = originalMessage + myChar;
            originalMessage += myChar;
        }
        System.out.println("Original Message : " + originalMessage);
    }
}