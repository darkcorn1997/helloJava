package collection;

public class ProducerThread extends Thread {
    private final MyStack<Character> stack;

    public ProducerThread(String name, MyStack<Character> stack) {
        super(name);
        this.stack = stack;
    }

    public char randomChar() {
        return (char)(Math.random()*('Z'+1-'A') + 'A');
    }

    @Override
    public void run() {
        while (true) {
            char c = randomChar();
            System.out.println(this.getName()+" 压入: " + c);
            stack.push(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
