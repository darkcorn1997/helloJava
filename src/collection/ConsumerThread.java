package collection;

public class ConsumerThread extends Thread {
    private final MyStack<Character> stack;

    public ConsumerThread(String name,MyStack<Character> stack) {
        super(name);
        this.stack =stack;
    }

    @Override
    public void run(){
        while(true){
            char c = stack.pull();
            System.out.println(this.getName()+" 弹出: " + c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
