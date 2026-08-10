class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("/:").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int del = str.indexOf("/:", i);
            int len = Integer.parseInt(str.substring(i, del));
            String s = str.substring(del + 2, del + 2 + len);
            result.add(s);
            i = del + 2 + len;
        }
        return result;
    }
}
