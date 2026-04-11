package lr4.task1;

public class Example8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(m());
        } catch (RuntimeException e) {  //не понял, нужно ли оставлять finally всегда выполняться, поэтому так
            System.out.println("2");
        }
    }
}


