import org.junit.Test;

import java.io.*;
import java.lang.annotation.Target;
import java.util.Arrays;

public class test1 {

    @Test
    public void FileTest() throws Exception {
        File f = new File("D:\\桌面文件\\java基础\\test\\test1\\data.txt");

        System.out.println(f.exists());
        System.out.println(f.getName());
        System.out.println(f.length());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.lastModified());

        System.out.println("============================");
        File f1 = new File("D:\\桌面文件\\java基础\\test\\test1\\data1.txt");
        System.out.println(f1.exists());
        System.out.println(f1.createNewFile());
        System.out.println(f1.exists());
        System.out.println(f1.length());
        File f2 = new File("D:\\桌面文件\\java基础\\test\\test1\\data");
        System.out.println(f2.mkdir());
        System.out.println(f2.exists());
        System.out.println(f2.isDirectory());

        System.out.println("=================");
        File f3 = new File("D:\\桌面文件\\java基础\\test\\test1\\data\\data3.txt");
        System.out.println(f3.createNewFile());
//        System.out.println(f.delete());
//        System.out.println(f1.delete());
//        System.out.println(f2.delete());
//
//        System.out.println(f3.delete());
//        System.out.println(f2.delete());


        System.out.println("===================");
        File f4 = new File("D:\\桌面文件\\java基础");
      /*对文件这样操作-报错
        File[] ff1 = f.listFiles();
        for (File s : ff1) {
            System.out.println(s);
        }*/
        String[] ff = f4.list();
        for (String s : ff) {
            System.out.println(s);
        }

        File[] fff = f4.listFiles();
        for (File file : fff) {
            System.out.println(file.getPath());
        }

    }

    @Test
    public void streamTest() throws Exception {
        try(InputStream is = new FileInputStream("D:\\桌面文件\\java基础\\test\\test1\\src\\data.txt");
            OutputStream os = new FileOutputStream("D:\\桌面文件\\java基础\\test\\test1\\data1.txt",true);
        ) {
            byte[] s = new byte[3];
            int c;
            while((c = is.read(s)) != -1){
                System.out.print(new String(s,0,c,"UTF-8"));
                os.write(s,0,c);
                os.write("\r\n".getBytes("UTF-8"));
            }
        } finally {
        }

    }


    @Test
    public void CharStreamTest() throws Exception {
        try(Reader r = new  FileReader("D:\\桌面文件\\java基础\\test\\test1\\src\\data.txt");
            Writer w = new  FileWriter("D:\\桌面文件\\java基础\\test\\test1\\data1.txt");
        ){
            int c;
            char[] s = new char[3];
            while((c = r.read(s)) != -1){
                System.out.println(new String(s,0,c));
                w.write(s,0,c);
                w.write("\r\n");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    @Test
    public void BufferStreamTest() throws Exception {
        InputStream bis = new BufferedInputStream(new FileInputStream("D:\\桌面文件\\java基础\\test\\test1\\src\\data.txt"));
        OutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\桌面文件\\java基础\\test\\test1\\data1.txt"));

        int c;
        byte[] s = new byte[3];
        while((c = bis.read(s)) != -1){
            System.out.println(new String(s,0,c));
            bos.write(s,0,c);
            bos.write("\r\n".getBytes());
        }

        bis.close();
        bos.close();
    }

    @Test
    public void CharBufferStreamTest() throws Exception {
        Reader br = new BufferedReader(new FileReader("D:\\桌面文件\\java基础\\test\\test1\\src\\data.txt"));
        Writer bw = new BufferedWriter(new FileWriter("D:\\桌面文件\\java基础\\test\\test1\\data1.txt"));

        int c;
        char[] s = new char[3];
        while((c = br.read(s)) != -1){
            System.out.println(new String(s,0,c));
            bw.write(s,0,c);
//            bw.write("\r\n");
            ((BufferedWriter) bw).newLine();
        }

        System.out.println(((BufferedReader) br).readLine());

        br.close();
        bw.close();
    }

    @Test
    public void TransStreamTest() throws Exception {
        Reader isr = new InputStreamReader(
                new FileInputStream(
                        "D:\\桌面文件\\java基础\\test\\test1\\src\\data.txt"),
                "UTF-8");
        Writer osw = new OutputStreamWriter(
                new FileOutputStream(
                        "D:\\桌面文件\\java基础\\test\\test1\\data1.txt"),
                "GBK");

        int c;
        char[] s = new char[3];
        while((c = isr.read(s)) != -1){
            System.out.println(new String(s,0,c));
            osw.write(s,0,c);
        }

        isr.close();
        osw.close();

    }

    @Test
    public void ObjectStreamTest() throws Exception{
        Student s = new Student("张三" ,33);

        System.out.println(s);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\桌面文件\\java基础\\test\\test1\\data\\data3.txt"));
        oos.writeObject(s);

        oos.close();

    }

    @Test
    public void ReObjectStreamTest() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\桌面文件\\java基础\\test\\test1\\data\\data3.txt"));
        Object o = ois.readObject();
        Student s = (Student) o;
        System.out.println(s);

    }

}
