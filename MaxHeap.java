/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GL3;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class MaxHeap {
    
    private int[] Heap; //Heap array of int type
    private int size;   //numbering strating from 1
    private int maxsize;//maximum size of the array
    private static boolean counterSearch = false,counterDelete = false; //counter for searchNode and deleteNode function
    private double xDiff = 30;// difference between gettingParent and child nodes horizontally
    private double yDiff = 300;//difference between gettingParent and child nodes vertically
    private double radius = 25;//radius of the circle for node
    private static Circle node[];     //contains all the circle nodes of tree      
    private static Line lines[];      //contains all the lines of the tree
    private static Label label[];      
    private static StackPane circlePane[];  //contains the circle and label of the tree

    public MaxHeap(int size) { //initialization of all variables necessary for the maxHeap
        this.maxsize = size;  
        this.size = 0;       
        Heap = new int[this.maxsize + 1]; 
        for(int i=0;i<size;i++){
            Heap[i]=-1;
        }
        Heap[0] = Integer.MAX_VALUE;
        node = new Circle[size];
        lines = new Line[size];
        label = new Label[size];
        circlePane = new StackPane[size];
        
    }

    private int gettingParent(int index) { //return gettingParent of the current node
        return index / 2;
    }
        private void swap(int pIndex, int cIndex) 
    { 
        int temp = Heap[pIndex]; 
        Heap[pIndex] = Heap[cIndex]; 
        Heap[cIndex] = temp; 
    }
    
    private void heapifyDown(int index)             //to be used for deletion
    { 
        if (index > size) 
            return; 
  
        if (Heap[index] < Heap[(2 * index)] ||  
            Heap[index] < Heap[(2 * index) + 1]) { 
            if (Heap[(2 * index)] > Heap[(2 * index) + 1]) { 
                swap(index, (2 * index)); 
                heapifyDown(2 * index); 
            } 
            else { 
                swap(index, (2 * index) + 1); 
                heapifyDown((2 * index) + 1); 
            } 
        } 
    }
    
    private void heapifyUp(int index) { //heap sort
        int temp = Heap[index];
        while(index>0 && temp > Heap[gettingParent(index)]){//checks if child is greater than the gettingParent
            Heap[index] = Heap[gettingParent(index)];//if so swaps the element
            index = gettingParent(index);
        }
        Heap[index] = temp;
    }


    public void insertNode(int element) throws IllegalArgumentException,ArithmeticException{ 
        for(int i=0;i<=size;i++)//checks that only unique element is inserted
        {
            if(Heap[i]==element){
                throw new IllegalArgumentException();//if not unique then throws error to notify the user
            }
        }
        Heap[++size] = element;//if unique insert the element in array
        int current = size;
        heapifyUp(current);//heap sort to balance the heap
    }
    
    public boolean deleteNode(int n,int index){
        if (index > size) { //checks if index is greater than the current size then return 
        return false;
        }
        
        if(Heap[index]==n){     //if the node is found
            int lastElement = Heap[size];   //gets last element
            Heap[index]=lastElement;        //replace it with the current node
            Heap[size]=-1;                  //delete the last node of the tree
            size--;
            heapifyDown(index);  //heap sort to balance the heap
            return true;     //returns true indicating everything was done successfully
        }
        
        // if not able to find the element then check in the left and right child
        if(counterDelete!=true){
            counterDelete = deleteNode(n,(2 * index));  
        }
        
        if(counterDelete!=true){
            counterDelete = deleteNode(n,(2 * index)+1);
        }
        
        if(index==1){
            if(counterDelete==true){//initializing counterDelete to be false at the end of stack of recursion
                counterDelete=false;
                return true;
            }
        }
        
        return counterDelete;
    }
    
    public boolean searchNode(int n,int index,Pane pane){
        if (index > size) { //checks if index is greater than size
            return false;
        }     
       
        if(index == 1){
            for(int i=1;i<=size;i++){  //set border of all nodes as black
                    node[i].setStroke(Color.BLACK); 
                    node[i].setFill(Color.WHITE);
            }
        }
        
        if(Heap[index]==n){ //if element found
            node[index].setStroke(Color.LAWNGREEN);//change its border to lawngreen
            node[index].setFill(Color.LAWNGREEN);
            label[index].setFont(Font.font("Verdana",FontWeight.BOLD,14));
            return true;
        }
        else{
             node[index].setStroke(Color.CRIMSON);
             node[index].setFill(Color.CRIMSON);
             label[index].setFont(Font.font("Verdana",FontWeight.BOLD,14));
        }
        
        // if not found searches left and right child of that node
        
        if(counterSearch!=true){
            counterSearch = searchNode(n,(2 * index),pane);
        }
        
        if(counterSearch!=true){
            counterSearch= searchNode(n,(2 * index)+1,pane);
        }
        
        if(index==1){
            if(counterSearch==true){//initializes the counter variable before exiting the function completely
                counterSearch=false;
                return true;
            }
        }
        return counterSearch;
    }
    
    public int getHeight(int n){
       
            int log = (int) (Math.log(n)/Math.log(2)); //if nodes are present returns height
            return ((int)Math.floor(log));
        
    }
    
    public void preOrderPrint(int index,TextField entryBottom){
        if(size==0){//to empty the textField if no nodes are present
            entryBottom.clear();
        }
        
        if (index > size) { // if greater than the size
            return;
        }
        
        if(index==1)  {// empty the TextField before printing the preOrderPrint
            entryBottom.setText("");
        }
        
        entryBottom.setText(entryBottom.getText()+" "+Heap[index]);//prints element
        preOrderPrint((2 * index),entryBottom);//check for left child of the node
        preOrderPrint((2 * index)+1,entryBottom);//check for right child of the node
    }
    
    public Pane displayingTree(BorderPane mainPane,int num) {
        Pane pane = new Pane();//creates new pane for displaying the tree
        if(Heap[1]!=-1){
            displayingTree(1, mainPane.getWidth() / 2.8,  mainPane.getHeight() / 4, yDiff ,pane,num);//if the heap is not empty then execute the code for creating the tree
        }
        return pane;
    }
    
    private void displayingTree(int index, double x, double y, double yDiff, Pane pane,int num) {
 
        if(index>size)
            return;
        
        if (Heap[(2*index)] != -1) { //checks if left node exists
            lines[2*index] = new Line(x - yDiff, y + xDiff, x, y);//create lines for the left node
            pane.getChildren().add(lines[2*index]); // display the line
            displayingTree(2*index, x - yDiff, y + xDiff, yDiff / 1.8,pane,num); // create the left subtree recursively  
        }
        if (Heap[(2*index)+1] != -1) {
            lines[(2*index)+1] = new Line(x + yDiff, y + xDiff, x, y); //create lines for the left node
            pane.getChildren().add(lines[(2*index)+1]);  //display the line   
            displayingTree((2*index)+1, x + yDiff, y + xDiff, yDiff / 1.8,pane,num); // create the right subtree recursively
        }

        node[index] = new Circle(x, y, radius); //create the node
        node[index].setFill(Color.WHITE);
        node[index].setStrokeWidth(3);
        label[index] = new Label(Heap[index] + ""); //add text on the node
        circlePane[index] = new StackPane(node[index],label[index]); // add circle and text in stackPane
        
        if(num==Heap[index]){
            node[index].setStroke(Color.LAWNGREEN); //change border for the current node being inserted
            node[index].setFill(Color.LAWNGREEN);
            label[index].setFont(Font.font("Verdana",FontWeight.BOLD,14));
        }
        else{
            node[index].setStroke(Color.BLACK); 
            node[index].setFill(Color.WHITE);
        }
        pane.getChildren().addAll(circlePane[index]); //display the node along with text
        circlePane[index].setTranslateX(node[index].getCenterX()-node[index].getRadius()); //set the x-coordinate of stackPane
        circlePane[index].setTranslateY(node[index].getCenterY()-node[index].getRadius()); //set the y-coordinate of stackPane
    }
}