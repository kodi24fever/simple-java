package main;

import java.util.*;
import java.io.*;

public class PA5 {
    private static final String INPUT = System.getProperty("user.dir")+"/input/";
    private static final String OUTPUT = System.getProperty("user.dir")+"/output/";

    public static void convert(String src, String trg) throws Exception {

        String srcExt = src.substring(src.length()-3);
        String trgExt = trg.substring(trg.length()-3);

        if(!srcExt.equals("txt") && !srcExt.equals("csv"))
            throw new Exception("bad format");
        if(!trgExt.equals("txt") && !trgExt.equals("csv"))
            throw new Exception("bad format");
        if(src.equals(trg))
            throw new Exception("same i/o");

        Scanner in = new Scanner(new File(INPUT + src));
        PrintWriter out = new PrintWriter(OUTPUT + trg);

        if(srcExt.equals(trgExt)) {//same formats

            if(srcExt.equals("txt")) {//txt->txt //It is good
                while(in.hasNextLine()) {
                    String[] cells = in.nextLine().split("\t");
                    for(int i = 0; i < cells.length;i++) {
                        String seperator = "\t";
                        if(i == cells.length - 1){
                            if(in.hasNextLine())
                                seperator = "\n";
                            else
                                seperator = "";
                        }
                        out.print(cells[i] + seperator);
                    }
                    out.flush();
                }
            }else {//csv->csv It is good
                if(srcExt.equals("csv")) {
                    while(in.hasNextLine()){
                        String[] cells = in.nextLine().split(",");
                        for(int i = 0; i < cells.length;i++) {
                            String seperator = ",";
                            if(i == cells.length - 1){
                                if(in.hasNextLine())
                                    seperator = "\n";
                                else
                                    seperator = "";
                            }
                            out.print(cells[i] + seperator);
                        }
                        out.flush();
                    }
                }
            }
        }else {
            if(srcExt.equals("txt")) {//txt->csv It is good
                //complete here
               while(in.hasNextLine()){
                   String[] cells = in.nextLine().split("\t" );

                   for(int i = 0; i < cells.length;i++) {
                       String separator = ",";

                       if(i == cells.length - 1){
                           if(in.hasNextLine())
                               separator = "\n";
                           else
                               separator = "";
                       }
                       out.print(cells[i] + separator);
                   }
                   out.flush();
               }

            }else {//csv->txt It is good
                while(in.hasNextLine()){

                    String[] cells = in.nextLine().split(",");
                    for(int i = 0; i < cells.length;i++) {
                        String seperator = "\t";

                        if(cells[i].startsWith("\"")){
                            int nextIndex = i + 1;
                            if(nextIndex < cells.length && cells[nextIndex].endsWith("\""))
                                seperator = ",";
                        }


                        if(i == cells.length - 1){
                            if(in.hasNextLine())
                                seperator = "\n";
                            else
                                seperator = "";
                        }
                        out.print(cells[i] + seperator);
                    }
                    out.flush();
                }
            }
        }
        out.close();
        in.close();
    }
    public static void normalize(String fileName) throws Exception{

        String delimiter = fileName.endsWith("txt")?"\t": ",";
        ArrayList<String>content = new ArrayList<String>();
        Scanner in = new Scanner(new File(INPUT + fileName));

        while(in.hasNextLine())
            content.add(in.nextLine());
        in.close();

        PrintWriter out = new PrintWriter(INPUT + fileName);

        int rows = content.size();

        for(String line: content) {
            String[] cells = line.split(delimiter);
            int cols = cells.length;
            for(String cell: cells){

                cols--;

                try{
                    int cellHasInt = Integer.parseInt(cell);
                    if(cell.length() < 10)
                        out.printf("%+010d", cellHasInt);
                    else
                        out.printf("%+d", cellHasInt);
                }catch (Exception exp){
                    try{
                        double cellHasDouble = Double.parseDouble(cell);
                        if(cellHasDouble > 100 || cellHasDouble < 0.01)
                            out.printf("%.2e", cellHasDouble);
                        else
                            out.printf("%.2f", cellHasDouble);
                    }catch (Exception exp1){
                        try {
                            float cellHasFloat = Float.parseFloat(cell);
                            if (cellHasFloat > 100 || cellHasFloat < 0.01)
                                out.printf("%.2e", cellHasFloat);
                            else
                                out.printf("%.2f", cellHasFloat);
                        }catch (Exception exp3){
                            if(cell == "")
                                out.print("N/A");
                            else if(cell.length() > 13)
                                out.printf("%.10s...", cell);
                            else
                                out.print(cell);
                        }
                    }
                }

                if(cols != 0)
                    out.print(delimiter);
            }
            rows--;
            if(rows != 0)
                out.println();
        }
        out.close();
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while(true){
            String command = keyboard.nextLine();
            String[] words = command.split(" ");
            if(words.length == 0){
                System.out.println("Error: the command is empty! Please try again!");
            }else if(words[0].equals("quit"))
                break;
            else if(words[0].equals("convert")) {
                if(words.length != 3 ||
                        !words[1].endsWith(".txt") && !words[1].endsWith(".csv") ||
                        !words[2].endsWith(".txt") && !words[2].endsWith(".csv")){
                    System.out.println("Error: the convert command needs to get 2 arguments:" +
                            " convert source.xxx destination.yyy where xxx and yyy are csv or txt!" +
                            " Please try again!");
                    continue;
                }

                try{
                    convert(words[1], words[2]);
                    System.out.println("converting " + words[1] + " to " + words[2]);
                }catch(Exception exp){
                    System.out.println("Error: conversion failed! " +
                            "Something is wrong w/ the format of the input file!" +
                            " Details: " + exp.getMessage() +
                            " Please enter a new command: ");
                }
            }else if(words[0].equals("normalize")){
                if(words.length != 2 ||
                        !words[1].endsWith(".txt") && !words[1].endsWith(".csv")) {
                    System.out.println("Error: the convert command needs to get 1 arguments:" +
                            " normalize source.xxx where xxx is either csv or txt!" +
                            " Please try again!");
                    continue;
                }
                try{
                    normalize(words[1]);
                    System.out.println("normalizing " + words[1]);
                }catch(Exception exp){
                    System.out.println("Error: normalize failed! " +
                            "Something is wrong w/ the format of the input file!" +
                            "Details: " + exp.getMessage() +
                            " Please enter a new command: ");
                }
            }
            else{
                System.out.println("Error: invalid command. Valid commands are quit, convert, normalize." +
                        "Please try again!");
            }
        }
    }
}

