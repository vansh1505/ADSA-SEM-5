class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] tex = text.split("\\s+");
        List<String> ans = new ArrayList<>();

        for(int i = 1; i < tex.length - 1; i++){
            String f = tex[i-1];
            String s = tex[i];
            String t = tex[i+1];
            if(f.equals(first) && s.equals(second)){
                ans.add(t);
            }
        }

        String[] res = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}