package Chapter_01;

import java.io.File;
import java.io.FileFilter;

public class CompareStream {

    public static void main(String[] args) {

        // 返回
        File[] file = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        //java8中
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);







    }
}
