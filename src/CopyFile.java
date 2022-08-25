import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    public static void copyAll(File f1, File f2) {
        try {
            //Copy bản thân nó
            Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (f1.isDirectory()) {
            //Copy các tập tin và thư mục con
            File[] mangCon = f1.listFiles();
            assert mangCon != null;
            for (File file : mangCon) {
                File files = new File(f2.getAbsoluteFile() + "/" + file.getName());
                copyAll(file, files);
            }
        }
    }

    public static void main(String[] args) {
        File f0 = new File("D:\\PHANMEM\\JAVA\\Module2\\File-CopyFileText\\src\\data1.txt");
        File f1 = new File("D:\\PHANMEM\\JAVA\\Module2\\File-CopyFileText\\src\\data2.txt");
        File f2 = new File("D:\\PHANMEM\\JAVA\\Module2\\File-CopyFileText\\src\\data3.txt");
        File f3 = new File("D:\\PHANMEM\\JAVA\\Module2\\File-CopyFileText\\src\\data4.txt");
        //Copy nội dung file txt
        try {
            Files.copy(f3.toPath(),f1.toPath(),StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
