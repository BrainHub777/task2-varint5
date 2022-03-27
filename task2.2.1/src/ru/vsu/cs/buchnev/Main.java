package ru.vsu.cs.buchnev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SimpleLinkedList.SimpleLinkedListException {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
    public static SimpleLinkedList readLinkedListFromFile(String fileName){
        try (Scanner scanner = new Scanner(new File(fileName), "UTF-8")) {
            String line;
            line=scanner.nextLine();
            return stringToLinkedList(line);
        }
        catch (FileNotFoundException e) {
            return null;
        }
    }
    public static SimpleLinkedList stringToLinkedList(String line){
        String[] arr=line.split(" ");
        SimpleLinkedList list = new SimpleLinkedList();
        for(int i=0; i< arr.length;i++){
            list.addLast(Integer.parseInt(arr[i]));


        }
        return list;
    }
    public static String stringFromLinkedList(SimpleLinkedList list) throws SimpleLinkedList.SimpleLinkedListException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            sb.append(list.get(i)+" ");
        }
        return sb.toString();
    }
}
