package Practice;

import java.io.File;
import Thread.TestThreadPool;

public class TestThread {
    TestThreadPool threadPool = new TestThreadPool();
    public void search(File file, String search) {
        if (file.isFile()) {
            if (file.getName().toLowerCase().endsWith(".java")) {
                SearchFileTask task = new SearchFileTask(file, search);
                threadPool.add(task);
            }
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f:files) {
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("/Users/xx/IdeaProjects/helloJava/src/Practice");
        new TestThread().search(file, "public");
    }
}
