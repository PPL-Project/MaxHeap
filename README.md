# <ins>Max-Heap</ins>
# Description
This is a Max-Heap Visualizer where you can add, delete and find elements. The height and number of nodes are updated simultaneously with each insertion and deletion. It also comes with the feature of printing the pre-order traversal of the tree.

Created using **Java**, **JavaFX**

## Max-Heap
A Max-Heap is a Complete Binary Tree. A-Max heap is typically represented as an array. The root element will be at Arr[0]. Below table shows indexes of other nodes for the ith node, i.e., Arr[i]: 
```
Arr[(i-1)/2] Returns the parent node. 
Arr[(2*i)+1] Returns the left child node. 
Arr[(2*i)+2] Returns the right child node.
```

## Objective

### <ins>[MaxHeap](https://github.com/PPL-Project/MaxHeap/blob/master/MaxHeap.java)</ins>
This class holds the basic functions for a max heap including insertion, deletion, heapifyUp, heapifyDown, find elements, pre-order traversal.

One of the main functions that update the stage after insertion, deletion, and finding:<br/>
**private void displayingTree(int index, double x, double y, double yDiff, Pane pane,int num)**<br/><br/>
This function creates each node, lines between each level, calculates the distance between each level for displaying as many nodes as possible. This function also ensures changing the color of the nodes depending on the operations.

### <ins>[MaxHeap_Test](https://github.com/PPL-Project/MaxHeap/blob/master/MaxHeap_Test.java)</ins>
This class creates the main UI for the application. It sets the complete stage, creating fields, stage for displaying the tree in the middle using HBox, VBox, Panes, Labels, Buttons, and TextFields. 

It also keeps track of the height and number of nodes, giving proper errors and pop-ups on the successful execution of the operations.

### <ins>UML Diagram</ins>
<img src="https://github.com/PPL-Project/MaxHeap/blob/master/Project_CSD203-2020_Aditya_Jayati_UML.png" width="600" height="500">
<br/>

# Local Setup

## Pre-Requisites
An IDE that supports Java and JavaFX.
## Installation and Execution
1. Pull this code into any folder.<br />
2. Open this folder in your preferred IDE.<br />
3. Build the Project.<br />
4. Run the [MaxHeap_Test.java](https://github.com/PPL-Project/MaxHeap/blob/master/MaxHeap_Test.java) file and the visualization for Max-Heap will be visible.<br />


# Screenshots
## Initial Window
<img src="https://user-images.githubusercontent.com/33955028/141093477-9aa37823-b91a-41cf-a606-70ff38e63e97.png" width="800" height="450">
<br/>

## Inserting Element in the Heap
<img src="https://user-images.githubusercontent.com/33955028/141093628-5ee1754e-c775-4137-aef0-fd4aa4523b5a.png" width="800" height="450">
<br/>

## Deleting Element from the Heap
<img src="https://user-images.githubusercontent.com/33955028/141093741-88db1f48-a224-47e1-8dfd-274c567aa3d9.png" width="800" height="450">
<br/>

## Finding the element in the Heap
<img src="https://user-images.githubusercontent.com/33955028/141093819-c578bc63-60a7-439b-875f-b842872f9196.png" width="800" height="450">
<br/>

## Printing Pre-Order Traversal of the Heap
<img src="https://user-images.githubusercontent.com/33955028/141093867-3b6caf6b-968a-4458-bb1a-7185c60265b8.png" width="800" height="450">
<br/>

# Contact
## 1. [Aditya Srivastava](mailto:aditya26052002@gmail.com?subject=GitHub)<br/><br/>2. Jayati Sharma<br/><br/>
