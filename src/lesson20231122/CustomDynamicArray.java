package lesson20231122;

import java.util.Arrays;

public class CustomDynamicArray {

    private int[] data;
    private int count;
    private int size;

    public CustomDynamicArray() {
        this.data = new int[1];
        this.count = 0;
        this.size = 1;
    }

    public CustomDynamicArray(int size) {
        this.data = new int[size];
        this.count = 0;
        this.size = size;
    }

    public void add(int element){
        if (count == size){
            growSize();
        }
        data[count++] = element;
    }

    public void addAt(int index, int element){
        if (index >= count) throw new RuntimeException("Index is out of bounds");
        if (count == size){
            growSize();
        }
        for (int i = count - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        count++;
    }

    private void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
        size = size * 2;
    }

    public void shrinkSize(){
        if (count < size){
            int[] newArray = new int[count];
            for (int i = 0; i < count; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
            size = count;
        }
    }

    public void remove(){
        data[--count] = 0; // make link to objects null for GC
    }

    public void removeAt(int index){

    }

    public void set(int index, int element){

    }

    public int get(int index){
        return 0;
    }

    public void clear(){

    }

    public int contains(int element){
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }




    public static void main(String[] args) {
        CustomDynamicArray array = new CustomDynamicArray();
        array.printInnerStructure();
        array.add(10);
        array.printInnerStructure();
        array.add(20);
        array.printInnerStructure();
        array.add(30);
        array.printInnerStructure();
        array.add(40);
        array.printInnerStructure();
        array.add(50);
        array.printInnerStructure();
        System.out.println(array);

        array.addAt(2, 999);
        array.printInnerStructure();

        array.shrinkSize();
        array.printInnerStructure();

        array.remove();
        System.out.println(array);
        array.printInnerStructure();
    }

    public void printInnerStructure(){
        System.out.println("Inner Structure: " + Arrays.toString(data));
    }

    @Override
    public String toString() {
        String result = "CustomDynamicArray[";
        for (int i = 0; i < count; i++) {
            result += data[i] + ", ";
        }
        result += "]";
        return result;
    }
}
