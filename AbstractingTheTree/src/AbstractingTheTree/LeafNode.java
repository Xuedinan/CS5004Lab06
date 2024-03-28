package AbstractingTheTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/* Course: CS5004
 * Semester: Spring 2024
 * Name: Xuedinan Gao
 * Assignment: Lab 06
 */

/*
LeafNode is a generic class and child of AbstractTreeNode. 
This node allows for a single data element. 

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/

public class LeafNode<T> extends AbstractTreeNode<T>{
	

	public <R> LeafNode(T data) {
		super();
	}

	@Override
	  public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T>
	          child) {
	    if (identifier.test((T) data)) {
	      //promote this to a group tree node
	      GroupNode<T> newNode = new GroupNode<>(this.data);
	      newNode.addChild(identifier,child);
	      return newNode;
	    }
	    return this;
	  }
	  
	  @Override
	  public List<T> toList() {
	    List<T> result = new ArrayList<T>();
	    result.add(this.data);
	    return result;
	  }
	  
	  @Override
	  public <R> TreeNode<R> map(Function<T,R> transform) {
	    return new LeafNode<R>(transform.apply(this.data));
	  }
	  
	  @Override
	  public T reduce(T initialValue, BiFunction<T, T,T> combiner) {
	    return combiner.apply(initialValue,this.data);
	  }

	@Override
	public void print() {
		System.out.println(this.data);
	}
}
