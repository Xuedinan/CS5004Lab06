/*
AbstractTreeNode takes its orders from TreeNode and sets up the basic, very simple, structure of a tree node. 
You'll have to fix the class declaration and complete this file. 
*/

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */



package AbstractingTheTree;

// implements TreeNode and provide filed attributes for child class
public abstract class AbstractTreeNode<T> implements TreeNode<T>{
	
	protected T data;

}