# programmers - level 1

```bash
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        char p = 'p';
        char y = 'y';

        long result = this.countChar(s);
        
        if(result==0){
            answer = true;
        }
        return answer;
    }
    
    public static long countChar(String str) {
        long pStringCount = str.chars().filter(c -> c == 'p').count();
        long yStringCount = str.chars().filter(c -> c == 'y').count();
        
        return pStringCount - yStringCount;
    }
}

```