//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int value = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end=0; end<s.length(); end++){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)+1);
            while (map.keySet().size()>k){
                char c = s.charAt(start);
                int count = map.get(c);
                if (count==1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c)-1);
                }
                start++;
            }
            value = Math.max(value, end-start+1);
        }
        return value;
    }
}