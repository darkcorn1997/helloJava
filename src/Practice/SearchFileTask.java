package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileTask implements Runnable{
    private File file;
    private String search;
    public SearchFileTask(File file, String search) {
        this.file = file;
        this.search = search;
    }

    public String readFileContent(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        try {
            char[] all = new char[(int)file.length()];
            fileReader.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        try {
            String fileContent = readFileContent(file);
            if (fileContent.contains(search)) {
                System.out.printf("线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(), search,file);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
