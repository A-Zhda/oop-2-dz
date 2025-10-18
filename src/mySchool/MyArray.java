package mySchool;

public class MyArray {
    Object[] myArray = new Object[10];
    int minCapacity = 10;

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
}
