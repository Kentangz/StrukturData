package Modul3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


class Stack{
    private String[] arrayStack;
    private int current, top;
    public Stack(int maxSize){
        this.arrayStack = new String[maxSize];
        current = -1;
        top = -1;
    }

    public void push(String input){
        arrayStack[top+1] = input;
        top += 1;
        current = top;
    }

    public String peek(){
        return arrayStack[current];
    }

    public String previous(){
        if(current <= 0){
            return null;
        }
        current--;
        return arrayStack[current];
    }

    public String next(){
        current += 1;
        return arrayStack[current];
    }
}

public class BrowserNavigation {

    public Scanner input = new Scanner(System.in);
    public Stack DB = new Stack(50);
    private String[] arrayHistory;
    private int act;

    public BrowserNavigation(int capacity) {
        this.arrayHistory = new String[capacity];
        this.act = -1;
    }

    public void takeHistory(String actMethod){
        LocalDateTime now = LocalDateTime.now();
        arrayHistory[act+1] = "-> " + actMethod + "(terakhir dikunjungi : " + dateFormatter(now) +")";
        act+=1;

    }

    private String dateFormatter(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public void browserHistory(){
        for(int i = act; i>=0; i--){
            System.out.println(arrayHistory[i]);
        }
        display();
    }

    public void visitURL(String URL){
        DB.push(URL);
        String output = "Masukan URL : " + DB.peek();
        System.out.println(output);
        takeHistory(output);
        display();
    }

    public void back(){
        String previousUrl = DB.previous();
        if(previousUrl == null){
            System.out.println("Tidak ada URL sebelumnya");
            display();
        }

        String output = "You returned to URL: " + previousUrl;
        System.out.println(output);
        takeHistory(output);
        display();
    }

    public void forward(){
        DB.next();
        if(DB.peek() == null){
            System.out.println("tidak ada URL selanjutnya");
            display();
        }
        String output = "Maju ke URL : " + DB.peek();
        System.out.println(output);
        takeHistory(output);
        display();
    }

    public void currentURL(){
        String output = "Kamu di URL : " + DB.peek();
        System.out.println(output);
        takeHistory(output);
        display();
    }


    public void display(){

        System.out.println("\n== Browser Navigation memakai stack ==");
        System.out.println("1.] Kunjungi URL");
        System.out.println("2.] kembali ke URL sebelumnya");
        System.out.println("3.] Ke URL depan");
        System.out.println("4.] URL Saat ini");
        System.out.println("5.] Browser History");
        System.out.println("6.] Exit");
        System.out.print("Pilih: ");
        String pilih = input.next();
        switch (pilih){
            case "1":
                System.out.print("Masukkan URL : ");
                String URL = input.next();
                visitURL(URL);
                break;
            case "2":
                back();
                break;
            case "3":
                forward();
                break;
            case "4":
                currentURL();
                break;
            case "5":
                browserHistory();
                break;
            case "6":
                System.out.println("Keluar Program");
                break;
            default:
                System.out.println("Input salah, masukkan lagi");
                display();
                break;
        }
    }
    public static void main(String[] args) {

        BrowserNavigation main = new BrowserNavigation(50);
        main.display();
    }
}