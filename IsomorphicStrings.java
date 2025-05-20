//Time Complexity: O(n)
//Space Complexity: O(n) //for hashmap of n characters and hashset of max n characters
//Approach: for each charcter in string s, map it to correspondign character in string t. Also maintain a hashset
// to maintain characters in t that have already been mapped by string s's characters. We set helps us tract if more than one character in string is mapped to same character in string t
import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<Character, Character>();
        HashSet<Character> tSet = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar) != tChar){
                    return false;
                }
            }
            else{
                sMap.put(sChar, tChar);
                if(tSet.contains(tChar)){
                    return false;
                }
                else
                    tSet.add(tChar);
            }
        }
        return true;
    }
}