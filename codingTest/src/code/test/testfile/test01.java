package code.test.testfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * */
public class test01 {

    public static void main(String[] args) {

        String today = "2022.05.19";

        String[] terms = {"A 6", "B 12", "C 3"};

        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        solution(today, terms, privacies);
    }

    public static int cnt = 0;
    public static List list = new ArrayList();

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        for (int i = 0; i < privacies.length; i++) {
            for (int j = 0; j < terms.length; j++) {
                String[] str = terms[j].split(" ");
                if (privacies[i].contains(str[0])) {
                    String sa = privacies[i].replace(str[0], str[1]);
                    privacies[i] = dateNum(sa);
                }
            }
            dateDiff(i, today, privacies[i]);
        }
        answer = new int[cnt];
        for(int i=0; i<answer.length;i++){
            answer[i] = (int) list.get(i);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void dateDiff(int n, String today, String date) {

        date = date.replace(".", "");
        today = today.replace(".", "");

        System.out.println(date);
        if (Integer.parseInt(date) < Integer.parseInt(today)) {
            cnt++;
            list.add(n+1);
        }
    }

    public static String dateNum(String sa) {

        String[] str = sa.split(" ");
        int limit = Integer.parseInt(str[1]);
        if(limit >= 12){
            limit = limit -1;
        }

        String[] date = str[0].split("[.]");

        int day = Integer.parseInt(date[2]);
        int mon = Integer.parseInt(date[1]) + limit;
        int year = Integer.parseInt(date[0]);

        if (day == 1) {
            day = 28;
        } else {
            day = day - 1;
        }
        if (mon > 12) {
            year = year + (mon / 12);
            mon = mon % 12;
        }

        date[0] = String.valueOf(year);
        date[1] = String.valueOf(mon);
        if (date[1].length() < 2) {
            date[1] = "0" + date[1];
        }
        date[2] = String.valueOf(day);
        if (date[2].length() < 2) {
            date[2] = "0" + date[2];
        }

        return String.join(".", date);
    }
}
