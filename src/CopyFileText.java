import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class CopyFileText {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Nhập tên tập tin nguồn: ");
            String sourceFile = br.readLine();
            System.out.print("Nhập tên tập tin đích: ");
            String targetFile = br.readLine();

            File source = new File(sourceFile);
            File target = new File(targetFile);

            if (!source.exists() || !target.exists()) {
                throw new FileAlreadyExistsException("File khong ton tai");
            }

            InputStream input = new FileInputStream(source);
            OutputStream output = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            input.close();
            output.close();
            System.out.println("Sao chép tập tin thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}