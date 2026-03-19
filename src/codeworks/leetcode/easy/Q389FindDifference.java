package codeworks.leetcode.easy;

public class Q389FindDifference {
	public static void main(String[] args) {
		System.out.println("---" + findTheDifference("abcd","abcde"));
	}
    public static char findTheDifference(String s, String t) {
        int sum1=0;
        for(int i=0;i<s.length();i++){
            sum1 += (int)s.charAt(i);
        }
        int sum2=0;
        for(int i=0;i<t.length();i++){
            sum2 += (int)t.charAt(i);
        }
        return (char)(sum2-sum1);
    }
    
    public char findTheDifference1(String s, String t) {
        int res = 0;

        for(char c : s.toCharArray())
            res -= c;

        for(char c : t.toCharArray())
            res += c;

        return (char) res;
    }
}
