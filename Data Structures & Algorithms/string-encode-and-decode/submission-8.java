class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(str.length());
            res.append('#');
            res.append(str);
        }
        System.out.println(res);

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        if (str.length() == 1) {
            res.add("");
            return res;
        }

        int ind = 0;
        char[] arr = str.toCharArray();

        while (ind < str.length()) {
            int len = 0;
            while (arr[ind] != '#') {
                len = len * 10 + (arr[ind] - '0');
                ind++;
            }
            ind++;
            res.add(str.substring(ind, ind + len));
            ind += len;
        }

        return res;
    }
}
