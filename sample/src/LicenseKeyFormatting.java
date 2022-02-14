public class LicenseKeyFormatting {
    public static void main(String[] args) {
//        String str = "8F3Z-2e-9-wabcdef";
		String str = "8F3Z-2e-9-w";
//		String str = "8-5g-3-J";
        int k =4;
        System.out.println(solve(str, k));
    }
    public static String solve(String str, int k){

        //1. del
        String newStr = str.replace("-", "");
        //2.
        newStr = newStr.toUpperCase();
        //3. k
        StringBuilder sb = new StringBuilder(newStr);

        int len = sb.length();
        for(int i=k; i < len; i=i+k){
            sb.insert(len-i, '-');

        }
        return sb.toString();
    }
}
