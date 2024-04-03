package Lab.modul1;

class Box<T>{
    private  T value;

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void  display(){
        System.out.println("Lab.modul1.Box contains: " +value);
    }
}

public class CodeLab {
    public static void main(String[]args){
        Box<Integer> IntegerBox = new Box<>();

        IntegerBox.setValue(42);

        int intValue = IntegerBox.getValue();
        System.out.println("integer value :" +intValue);

        Box<String> stringBox = new Box<>();

        stringBox.setValue("hello, generics");

        String stringvalue = stringBox.getValue();
        System.out.println("string value :" +stringvalue);
    }
}