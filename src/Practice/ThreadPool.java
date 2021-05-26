package Practice;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
        File file = new File("/Users/xx/IdeaProjects/helloJava/src/Practice");

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                new TestThread().search(file, "public");
            }
        });
    }
}
