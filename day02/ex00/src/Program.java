import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

    public static HashMap<String, String> parseSignatures(File signatures) throws FileNotFoundException {
        HashMap<String, String> signMap = new HashMap<>();
        String subRow;
        String key;
        String value;

        Scanner scan = new Scanner(signatures);

        while(scan.hasNext() == true) {
            subRow = scan.next();
            if (subRow.lastIndexOf(",") != subRow.length() - 1) {
                return null;
            } else {
                key = subRow.substring(0, subRow.length() - 1);
            }
            value = scan.nextLine();
            value = value.replace(" ", "");
            signMap.put(key,value);
        }
        return signMap;
    }


    private static String bytesToHex(byte[] bytes) {
        final char[] hex = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {

            int v = bytes[j] & 0xFF;

            hexChars[j * 2] = hex[v >>> 4];
            hexChars[j * 2 + 1] = hex[v & 0x0F];
        }

        return new String(hexChars);
    }

    public static String isSign(HashMap<String, String> signaturesMap, String hexSignature) {
        Collection<String> signs = signaturesMap.values();
        for (String s: signs) {
            String substr = hexSignature.substring(0, s.length());
            if(substr.equals(s)) {
                return s;
            }
        }
        return null;
    }

    public static void checkSign(String path, HashMap<String, String> signaturesMap) throws IOException {
        File checkSignatureFile = new File(path);

        if (!checkSignatureFile.isFile() && !checkSignatureFile.canRead()) {
            System.err.println("File not exists");
            return;
        }

        FileInputStream checkSignature = new FileInputStream(checkSignatureFile);

        byte[] sign = new byte[8];

        checkSignature.read(sign, 0, 8);

        String hexSignature = bytesToHex(sign);

        String rightSignature = isSign(signaturesMap, hexSignature);

        if (rightSignature != null) {

            FileWriter out = new FileWriter("result.txt", true);

            out.append(rightSignature + '\n');
            out.close();
            System.out.println("PROCESSED");
        } else {
            System.out.println("UNDEFINED");
        }
        checkSignature.close();
    }

    public static void main(String[] args) throws IOException {
        File signatures = new File("signatures.txt");

        if (!signatures.isFile() && !signatures.canRead()) {
            System.err.println("File signatures.txt not exists");
            return;
        }
        HashMap<String, String> signaturesMap = parseSignatures(signatures);

        Scanner scan = new Scanner(System.in);

        String path = scan.nextLine();
        if(path.equals("42") == false) {
            FileWriter answer = new	FileWriter("result.txt", false);
            while (path.equals("42") == false) {
                checkSign(path, signaturesMap);
                path = scan.nextLine();
            }
            answer.close();
        }
    }

}
