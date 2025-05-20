//Time Complexity: O(n) // where n is number of characters in string pattern
//Space Complexity: O(n)
//Approach: Similar to isomorphic strings problem, maintain hashmap to track what word each characetr in string pattern maps to 
// also maintain a hashset to check if  more than one charcter in string pattern maps to same word in string s. If character to string mapping isn't consistent return false, else true
import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(words[i])){
                    return false;
                }
            }
            else{
                map.put(ch, words[i]);
                if(set.contains(words[i])){
                    return false;
                }
                set.add(words[i]);
            }
        }
        return true;
    }
}