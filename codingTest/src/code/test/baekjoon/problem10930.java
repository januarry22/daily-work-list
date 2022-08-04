package code.test.baekjoon;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 - sha-256
 *
 * */
public class problem10930 {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);

        StringBuffer sb = new StringBuffer();
        String S = sc.nextLine();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(S.getBytes("UTF-8"));


        for(int i=0; i < hash.length; i++){
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) sb.append('0');

            sb.append(hex);
        }

        System.out.println(sb.toString());
    }

}
