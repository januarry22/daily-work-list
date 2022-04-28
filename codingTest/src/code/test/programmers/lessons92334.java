package code.test.programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lessons92334 {
    public static String id_list[] = {"muzi", "frodo", "apeach", "neo"};
    // "이용자id 신고한id"형태의 문자열
    public static String report[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    // 정지되는 신고 회수 기준
    public static Integer k = 2;

    public static void main(String[] args){
        int[] isCheck = solution(id_list,report,k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map<String,Object> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for(String ids : id_list){
            List news = new ArrayList();
            map.put(ids, news);
        }
        for(String reports : report){
            String[] newid = reports.split(" ");
            if(newid[0]==map.get(newid[0])){
                List newd = new ArrayList();
                newd.add(newid[1]);
                map.get(newid[0]);
            }
        }
        System.out.print("Dddddd"+map);

        return answer;
    }

}
