class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                String st = s.substring(i, Math.min(i + k, s.length()));
                int sum = 0;

                for (char c : st.toCharArray()) {
                    sum += c - '0';
                }
                ans.append(sum);
            }
            s = ans.toString();
        }

        return s;
    }
}