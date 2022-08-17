package code.test.programmers;

import java.util.*;

/*
 * [프로그래머스] - 여행경로
 * */
public class lessons43164 {
    public static boolean[] visit;
    static ArrayList<String> list = new ArrayList<>();
    public static String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

    public static void main(String[] args) {
        visit = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        System.out.println(Arrays.toString(answer));
    }


    public static void dfs(int depth, String now, String path, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && now.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }


}
