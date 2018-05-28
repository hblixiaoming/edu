import com.lxm.synch.SynchThread;

public class Test {
    public static void main(String[] args) {
//        int a = 256;
//        Integer b = 256;
//        Integer c = new Integer(256);
//        Integer d = new Integer(256);
//
//        System.out.println(a == b);
//        System.out.println(c == d);
//        System.out.println(b == c);

        System.out.println(coverCardNo("6217580100003386828"));
    }

    public static String coverCardNo(String cardNo){
        final int length = cardNo.length();
        String head = cardNo.substring(0, 4);
        String tail = cardNo.substring(length - 4);
        String middle = cardNo.substring(4, length - 4).replaceAll("\\d","*");
        return head + middle + tail;
    }
}
