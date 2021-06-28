/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Random;
/**
 *
 * @author PC
 */
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
  
    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity.
    public MaxHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    public int[] getHeap() {
        return Heap;
    }

    public void setHeap(int[] Heap) {
        this.Heap = Heap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }
  
    // Returns position of parent
    public int parent(int pos) { 
        return pos / 2; 
    }
  
    // Below two functions return left and
    // right children.
    public int leftChild(int pos) {
        return (2 * pos); 
    }
    public int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
  
    // Returns true of given node is leaf
//    public boolean isLeaf(int pos)
//    {
//        System.out.println(size/2);
//        if (pos > (size / 2) && pos < size) {
//            return true;
//        }
//        return false;
//    }
    public boolean isLeaf(int pos){
        if(leftChild(pos) > size){
            return true;
        }
        return false;
    }

    
    public void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
  
    // A recursive function to max heapify the given
    // subtree. This function assumes that the left and
    // right subtrees are already heapified, we only need
    // to fix the root.
public void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;
  
        if (Heap[pos] < Heap[leftChild(pos)]
            || Heap[pos] < Heap[rightChild(pos)]) {
  
            if (Heap[leftChild(pos)]
                > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
  
    // Inserts a new element to max heap
    public void insert(int element)
    {
        Heap[++size] = element;
  
        // Traverse up and fix violated property
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
  
    public void print()
    {
        for (int i = 1; i < size / 2; i++) {
            System.out.print(
                " Padre : " + Heap[i]
                + " Hijo Izquierdo : " + Heap[2 * i]
                + " Hijo Derecho :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
  
    // Remove an element from max heap
    public int extractMax()
    {
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
    public int generadorRandom(){
        Random rand = new Random();
        int low = 500;
        int high = 1001;
        int result = rand.nextInt(high-low) + low;
        return result;
    }
    
    public void insertarHijos(int num){        
//        for(int i = 0;i < 7 ; i++){
        for(int i = 0; i < num ;i++){
            insert(generadorRandom());
        }
        System.out.println("Jedis tree creado");
    }
    public int obtenerPoder(int posicion){
        if(posicion != 0){
            if(posicion != 1){
                int poder = 0;
                //&& !isLeaf(Heap[2 * posicion])
                while(posicion <= size / 2){        
                    poder+=Heap[posicion];
                    poder+=Heap[2 * posicion];
                    poder+=Heap[2 * posicion + 1];
                    posicion*=2;
                }
                return poder;
            }
            int poder = 0;
            poder+=Heap[posicion];
            while(posicion <= size / 2){        
                poder+=Heap[2 * posicion];
                poder+=Heap[2 * posicion + 1];
                posicion++;
            }
            return poder;
        }
        System.out.println("Ingrese una posición diferente de 0.");
        return 0;
        
    }
}

