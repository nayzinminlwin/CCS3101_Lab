public class CND_anotherTest_ErrorDetection {

    public static void main(String[] args) {
        String userData = "Hi";

        // send userData via sendData function, it will return the encodedBinary data
        String[] encodedData = sendData(userData);
        System.out.println();

        // toggle this cmt to see message interrupted.
        // encodedData[4] = "0";

        // decoding function ; fromt binary back to original msg
        receiveData(encodedData);

    }

    public static String[] sendData(String userData) {
        System.out.println("User Data : " + userData);

        // encoded data array will be same size with userData length
        // if user data : "Hi" ;
        // encodedData will be : ["10010001101001",".10010001101001"]
        // one array room for one char each.
        String[] encodedData = new String[userData.length()];

        // looping
        for (int i = 0; i < encodedData.length; i++) {
            // in loops ;
            // For visualization and validation, try to print what u wanna know/see

            char aChar = userData.charAt(i);
            // System.out.println(aChar); // current char

            String binaryData = Integer.toBinaryString(aChar);
            // System.out.println(binaryData);
            encodedData[i] = binaryData; // masuk binaryData into current room of encodedData Array
        }

        // the following 4 lines is just printing sexy 0 and 1s.
        System.out.print("Sending data . . .");
        for (String string : encodedData) {
            System.out.print(string);
        }

        // return to catch encodedData inside main method
        return encodedData;
    }

    // this function will do the reverse/upsideDown what sendData function did
    public static void receiveData(String[] encodedData) {

        // just sexy printing
        System.out.println("Received Bits . . ." + String.join("", encodedData));

        // the translate message from binary to char will added into this
        // originalMessage variable
        String originalMessage = "";

        // looping to translate each binary inside encodedData to char
        // Each binaryCode -> char
        for (int i = 0; i < encodedData.length; i++) {
            String currentRoom = encodedData[i];

            // // parseInt function will change binary to decimal
            // int myAscii = Integer.parseInt(currentRoom, 2);
            // // 2 in second parameter mean Binary, if 16, it is saying HEXA
            // // typecasting ASCII int to char // java know itself
            // char myChar = (char) myAscii;

            // the two lines commented above, written in one line.
            char myChar = (char) Integer.parseInt(currentRoom, 2);

            // System.out.println("First Char : " + myChar);

            // adding char to string is simple
            // originalMessage = originalMessage + myChar;
            originalMessage += myChar;
        }
        System.out.println("Original Message : " + originalMessage);
    }
}