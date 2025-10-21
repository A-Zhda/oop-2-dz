package mySchool;

public class MyArray implements MyArrayInterface{
    protected Object[] myArray;
    protected int minCapacity = 10;
    protected int size;

    public MyArray() {
        this.myArray = new Object[minCapacity];
        this.size = 0;
    }

    public MyArray(int newCapacity) {
        this.myArray = new Object[newCapacity];
        this.size = 0;
    }

    public Object[] getMyArray() {
        return myArray;
    }

    public Object[] addElement(Object[] recieveArray, Object object){
        if (recieveArray.length > minCapacity) growArray();

        int fullCell = 0;
        for (int i = 0; i < recieveArray.length; i++) {
            if (recieveArray[i] == null) break;
            myArray[i] = recieveArray[i];
            fullCell++;
        }
        myArray[fullCell] = object;
        return myArray;
    }
    
    public void growArray(){
        Object[] myNewArray = new Object[myArray.length * 2];
        minCapacity*=2;
        
        myArray = myNewArray;
    }

    @Override
    public void add(Object obj) {
        if (size == myArray.length){
            Object[] newArray = new Object[myArray.length*2];
            for (int i = 0; i < myArray.length; i++) {
                newArray[i] = myArray[i];
            }
            myArray = newArray;
        }
        myArray[size] = obj;
        size++;
    }

    @Override
    public Object get(int index) {
       if (index < 0 || index > size){
           System.err.println("Индекс за границами  массива");
           return null;
       }
       return myArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, Object obj) {
        if (index < 0 || index > size){
            System.err.println("Индекс за границами  массива");
            return;
        }
        myArray[index] = obj;
    }
}
