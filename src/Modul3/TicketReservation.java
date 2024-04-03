package Modul3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Queue{


    public String[] arrayName, arrayCode, arrayOrder;
    private int tail;
    public String getArrayName(int i) {return arrayName[i];}
    public String getArrayCode(int i){return arrayCode[i];}
    public Queue(int maxSize) {
        this.arrayName = new String[maxSize];
        this.arrayCode = new String[maxSize];
        this.arrayOrder = new String[maxSize];
        tail = -1;
    }
    public void add(String input1, String input2){
        arrayName[tail+1] = input1;

        arrayCode[tail+1] = input2;
        tail +=1;
    }
    public String peek(int i){
        arrayOrder[i] = "Name : " + getArrayName(i) + " | Unique code : " + getArrayCode(i);
        return arrayOrder[i];
    }
    public void poll(int i){
        arrayName[i] = arrayName[i+1];
        arrayCode[i] = arrayOrder[i+1];
        arrayOrder [i] = arrayOrder[i+1];
    }
    public Boolean isEmpty(){
        return arrayName[0] == null;
    }
}
public class TicketReservation {
    public Scanner input = new Scanner(System.in);
    public Queue DB = new Queue(100);
    private int take;
    public TicketReservation() {
        this.take = -1;
    }
    public String setCode(int i){
        LocalDate now = LocalDate.now();
        String formatted = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        int sequence = (i+1);
        String uniqueCode = formatted + String.format("%03d", sequence);
        long value = Long.parseLong(uniqueCode);
        String hexCode = Long.toHexString(value);
        return hexCode.toUpperCase();
    }
    public void orderTicket(){
        System.out.println("\n== Option - Order Ticket ==");
        System.out.print("Enter Quantity(Ticket) : ");
        int total = input.nextInt();
        for(int i = 0; i < total;i++){
            System.out.print("Input name " + (i+1) + ":" );
            String name = input.next();
            name = name.toUpperCase();
            String code = setCode(i);
            if(name.equals("0")){
                name = DB.getArrayName(i-1);
            }
            System.out.println("Your ticket :" + code);
            DB.add(name, code);
            take +=1;
        }
        display();
    }
    public void checkTicket(){
        if(DB.isEmpty()){
            System.out.println("Tidak ada tiket yang dipesan, silahkan order dulu");
        } else {
            System.out.println("Display Queue: ");
            for(int i = 0; i <= take; i++){
                System.out.println((i+1) + ". " + DB.getArrayName(i) + " " + DB.getArrayCode(i));
            }
        }
        display();

    }
    public void cancelTicket(){
        System.out.println("\n== Option - Cancel Ticket ==");
        if(DB.isEmpty()){
            System.out.println("Data is empty, please order first !!");
            display();
        }
        System.out.print("Enter your Unique code : ");
        String checkCode = input.next();
        for(int i = 0; i <= take; i++){
            if(checkCode.equals(DB.getArrayCode(i))){
                System.out.println("Your order has been found!");
                DB.peek(i);
                System.out.println("cancel ticket? \n1.] Yes\n2.] No");
                System.out.print("Choose option : ");
                String choose = input.next();
                if(choose.equals("1")){
                    System.out.println("Succesfully cancelled -> " + DB.peek(i));
                    DB.poll(i);
                    display();
                }
                else{
                    System.out.println("Back to menu");
                    display();
                }
            }
        }
        System.out.println("Your code couldn't found !!");
        display();
    }

    public void display(){
        System.out.println("\n== Order Ticket using Queue ==");
        System.out.println("1.] Order Ticket");
        System.out.println("2.] Check Ticket");
        System.out.println("3.] Cancel Ticket");
        System.out.println("4.] Exit");
        System.out.print("Choose option : ");
        String choose = input.next();

        switch (choose){
            case "1":
                orderTicket();
                break;
            case "2":
                checkTicket();
                break;
            case "3":
                cancelTicket();
                break;
            case "4":
                System.out.println("Exiting program....");
                System.out.println("See you next time :)\n");
                break;
            default:
                System.out.println("Invalid input, try again !!\n");
                display();
                break;
        }
    }
    public static void main(String[] args) {
        TicketReservation main = new TicketReservation();
        main.display();
    }
}
