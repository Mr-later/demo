package com.wsw.demo;

import org.junit.Before;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

public class SpiltFileTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("start=========");
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add(i);
        }
        list.remove(0);
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static void spitMeth1() {
        SpiltFileTest.makeTxtFileByPath("D:\\SpiltFileTest","all.txt");
        BufferedReader reader=null;
        BufferedWriter writer=null;
        try {
            reader = new BufferedReader(new FileReader("D:\\SpiltFileTest\\all.txt"));
            writer=new BufferedWriter(new FileWriter("D:\\SpiltFileTest\\1.txt"));;
            String s;
            int filenum=1;
            int linenum=0;
            while ((s=reader.readLine())!=null){
                if(linenum>=20000){
                    filenum+=1;
                    linenum=0;
                    writer = new BufferedWriter(new FileWriter("D:\\SpiltFileTest\\"+filenum+".txt"));
                }
                writer.write(s);
                writer.newLine();
                linenum+=1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    public static void    makeTxtFileByPath(String path,String fileName){
        BufferedWriter writer = null;
        FileWriter fw = null;
        try {
            File file = new File(path, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }else{
                file.delete();
                file.createNewFile();
            }
            ;
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            int originLine = 1234567;
            for (int i = 1; i <= originLine; i++) {
                writer.write("王世伟爱小艾"+i+"遍");
                writer.newLine();
            }
            fw.flush();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}