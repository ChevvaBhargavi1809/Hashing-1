//Time Complexity: O(n*k)
//Space Complexity: O(n)
//Approach: compute hash using form factor method(assign primes to alphabets and compute product of those primes for characters of word)
//create a map where key is the computed prime hash and value is list of strings that have the same hash
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();
        for(String str: strs){
            double prime = computeHash(str);
            if(!map.containsKey(prime)){
                map.put(prime, new ArrayList<String>());
            }
            map.get(prime).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public double computeHash(String str){
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        double res = 1;
        for(int i=0;i<str.length();i++){
            res = res * primes[str.charAt(i)-'a'];
        }
        return res;
    }
}