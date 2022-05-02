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
        for(int j : isCheck){
            System.out.print("isCheck"+j);
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String, Integer> longMap = new HashMap<>();

        for(String ids : id_list){
            List news = new ArrayList();
            resultMap.put(ids, news);
            longMap.put(ids,0);
        }

        for(String reports : report){
            String[] newid = reports.split(" ");
            String sign = newid[0];
            String signed = newid[1];
            List fromsigned = (List) resultMap.get(sign);
            fromsigned.add(signed);
            longMap.put(sign,fromsigned.size());
        }
        int[] result = new int[id_list.length];
        for(int i=0; i<result.length;i++){
            result[i] = longMap.get(id_list[i]);
        }

        return result;
    }

}
