import java.util.regex.Matcher;
import java.util.regex.Pattern;

class binarygap {

    public static int solution(int N) {
        if (N <= 5) {
            return 0;
        }

        String number = Integer.toBinaryString(N);
        if (number.length() <= 2) {
            return 0;
        } else {
            String gaps = "10+1";
            Pattern r = Pattern.compile(gaps);
            Matcher finding = r.matcher(number);
            int max = 0;
            while (finding.find()) {
                int possibleGap = finding.group(0).length() - 2 ;
                if ( possibleGap > max) {
                    max = possibleGap;
                }
            }
            return max;
        }
    }

    public static String reverse ( String s ) {
        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();
        for ( int i = 0; i < length / 2; i++ ) {
            char c = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = c;
        }
        return new String(chars);
    }

    public static void reverseIt() {
        String reverseMe = "reverse me!";
        for (int i = 0; i < reverseMe.length(); i++) {
            reverseMe = reverseMe.substring(1, reverseMe.length() - i)
                        + reverseMe.substring(0, 1)
                        + reverseMe.substring(reverseMe.length() - i, reverseMe.length());

            System.out.println(reverseMe);
            System.out.println(reverseMe.substring(1, reverseMe.length() - i));
            System.out.println(reverseMe.substring(0, 1));
            System.out.println(reverseMe.substring(reverseMe.length() - i, reverseMe.length()));

        }
        System.out.println(reverseMe);

        public static void sumFile ( String name ) {
            try {
                int total = 0;
                BufferedReader in = new BufferedReader ( new FileReader ( name ));
                for ( String s = in.readLine(); s != null; s = in.readLine() ) {
                    total += Integer.parseInt ( s );
                }
                System.out.println ( total );
                in.close();
            } catch ( Exception xc ) {
                xc.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        int gaps = solution(1041);
        System.out.println(gaps);
        reverseIt();
    }
}
