package LeetCode;


@SuppressWarnings("unused")
public class test {

    public static void main(String[] args) {
        Thread s = new Thread(() -> {
            while (true)
                System.out.println("b");
        });
        s.start();
        Thread q = new Thread(()->{
            while (true)
                System.out.println("a");
        });
        q.start();
        while (true){
            System.out.println("sdf");
        }
    }
}
