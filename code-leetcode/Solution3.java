import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution3 {

	public static void main(String[] args) {
		String s = "dvdf";
		Solution3 sol = new Solution3();
		System.out.println(sol.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int length = s.length();

		int longest = 1;

		int repeat = 0;
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			if (queue.isEmpty()) {
				queue.add(s.charAt(i));
			} else {
				int index = s.substring(repeat, i).indexOf(s.charAt(i));
				if (index > -1) {
					if (queue.size() > longest) {
						longest = queue.size();
					}
					repeat += (index+1);
					for (int j = 0; j <= index; j++) {
						queue.poll();
					}
				}
				queue.add(s.charAt(i));
			}
		}
		if (!queue.isEmpty()) {
			if (queue.size() > longest) {
				longest = queue.size();
			}
		}
		return longest;
	}
}
