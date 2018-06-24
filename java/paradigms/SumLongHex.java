public class SumLongHex {

    public static void main(String[] args) {
        long ans = 0;

        for (int i = 0; i < args.length; i++) {
            int x = 0;
            for (int j = 0; j <= args[i].length(); j++) {
                if (j != args[i].length() && !Character.isWhitespace(args[i].charAt(j))) {
                    continue;
                }
                if (j - x > 2 && args[i].substring(x, x + 2).toUpperCase().equals("0X") ) {
                    ans += Long.parseUnsignedLong(args[i].substring(x + 2, j), 16);
                } else if (x < j) {
                    ans += Long.parseLong(args[i].substring(x, j));
                }


                x = j + 1;
            }

        }

        System.out.println(ans);
    }

}
