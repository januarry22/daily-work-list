package code.test.programmers;

import java.util.*;

// 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
/*
    1) 아이디의 길이는 3자 이상 15자 이하여야 합니다.
    2) 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
    3) 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.

    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

    예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
    예2	"z-+.^."	"z--"
    예3	"=.="	"aaa"
    예4	"123_.def"	"123_.def"
    예5	"abcdefghijklmn.p"	"abcdefghijklmn"
 */
public class lessons72410 {
    public static String testEmail = "=.=";

    public static void main(String[] args){
        String isCheck = solution(testEmail);
        System.out.print("isCheck:::"+isCheck+"\n");
    }

    public static String solution(String checkString){
        // 1단계 : 대문자 -> 소문자 치환
        String lowerReplace = checkString.toLowerCase();
        System.out.print("1:::"+lowerReplace+"\n");

        // 2단계
        lowerReplace = lowerReplace.replaceAll("[^a-z0-9-_.]","");
        System.out.print("2:::"+lowerReplace+"\n");

        // 3단계
        lowerReplace = lowerReplace.replaceAll("[.]{2,}",".");
        System.out.print("3:::"+lowerReplace+"\n");

        // 4단계
        lowerReplace = lowerReplace.replaceAll("^[.]|[.]$","");
        System.out.print("4:::"+lowerReplace+"\n");


        // 5단계
        if(lowerReplace.equals("")){
            lowerReplace = "a";
        }
        System.out.print("5:::"+lowerReplace+"\n");

        // 6단계
        if(lowerReplace.length()>=16){
            lowerReplace = lowerReplace.substring(0,15);
            lowerReplace = lowerReplace.replaceAll("[.]$","");
        }
        System.out.print("6:::"+lowerReplace+"\n");


        if(lowerReplace.length()<=2){
            String plus = lowerReplace.substring(lowerReplace.length()-1);
            while(lowerReplace.length()<3){
                lowerReplace += plus;
            }
        }

        System.out.print("7:::"+lowerReplace+"\n");

        return lowerReplace;
    }

}
