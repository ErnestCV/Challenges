public class Main {
    public static void main(String[] args) {

        String s = "xcyc";

        String s1 = "xc";
        String s2 = "cy";

        find(s, s1, s2);

    }

    public static void find(String target, String s1, String s2) {
        findRec(target, s1, s2, 0, 0);
    }

    public static boolean findRec(String target, String rem1, String rem2, int c1, int c2) {

        int total = c1 + c2;

        if (target.length() == total) {
            System.out.println("Aconseguit");
            return true;
        }

        if (total < target.length()) {
            if (rem1.length() > 0 & rem2.length() > 0) {
                if ((rem1.charAt(0) == target.charAt(total)) & (rem2.charAt(0) == target.charAt(total))) {
                    return findRec(target, rem1.substring(1), rem2, c1 + 1, c2) |
                            findRec(target, rem1, rem2.substring(1), c1, c2 + 1);
                }
            }
            if (rem1.length() > 0) {
                if (rem1.charAt(0) == target.charAt(total)) {
                    return findRec(target, rem1.substring(1), rem2, c1 + 1, c2);
                }
            }
            if (rem2.length() > 0) {
                if (rem2.charAt(0) == target.charAt(total)) {
                    return findRec(target, rem1, rem2.substring(1), c1, c2 + 2);
                }
            }
        }

        return false;
    }

}