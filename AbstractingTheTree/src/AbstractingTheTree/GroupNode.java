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
GroupNode is a generic class and child of AbstractTreeNode. 
This node takes the place of a supervisor. 
It allows for a single data element along with an array list of other elements.

You'll have to include the needed imports, fix the class declaration, and then populate the body with the needed methods.
*/

public class GroupNode<T> extends AbstractTreeNode<T>{
	
	private List<TreeNode<T>> children;

	public <R> GroupNode(R apply) {
       children = new ArrayList<>();
	}

	@Override
	  public TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> child) {
	    if (identifier.test(this.data)) {
	      this.children.add(child); //add it here and return
	      return this;
	    }
	    for (int i=0;i<this.children.size();i++) {
	      //add to child and mutate the child
	      this.children.set(
	              i,
	              this.children.get(i).addChild(identifier,child));
	    }
	    return this;
	  }
	
	  @Override
	  public List<T> toList() {
	    List<T> result = new ArrayList<T>();
	    result.add(this.data);
	    for (TreeNode<T> child: children) {
	      result.addAll(child.toList());
	    }
	    return result;
	  }
	  
	  @Override
	  public <R> TreeNode<R> map(Function<T,R> transform) {
	    GroupNode<R> newNode = new GroupNode<R>(transform.apply(this.data));
	    for (TreeNode<T> child:children) {
	      newNode.children.add(child.map(transform));
	    }
	    return newNode;
	  }
	  
	  @Override
	  public T reduce(T initialValue, BiFunction<T,T,T> combiner) {
	    T result = this.data;
	    for (TreeNode<T> child:children) {
	      result = child.reduce(result,combiner);
	    }
	    //at this point result is the combination of this.data and reductions of its children
	    return combiner.apply(initialValue,result); //combine result and initialValue and return
	  }

	@Override
	public void print() {
        System.out.println(this.data); // printing the data of the node
        for (TreeNode<T> child : children) {
            child.print(); // recursively print children
        }
	}
}