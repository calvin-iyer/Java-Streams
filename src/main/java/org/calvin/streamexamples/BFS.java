package org.calvin.streamexamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CalvinI
 *
 */
public class BFS {

	public static void main(String[] args) {
		BTreeNode<String> root = new BTreeNode<String>("root");
		
		addData(root,10);
		
		HashSet<BTreeNode<String>> results = bfs(root,"left5");
		System.out.println("Results : "+results.size());
		results.stream().forEach((BTreeNode<String> node) -> System.out.println(node.getData() + " "));
	}
	
	private static void addData(BTreeNode<String> node,int ctr) {
		node.setLeftChild(new BTreeNode<String>("left"+ctr));
		node.setRightChild(new BTreeNode<String>("right"+ctr));
		if(ctr > 0) {
			addData(node.getLeftChild(),ctr-1);
			addData(node.getRightChild(),ctr-1);
		}
	}
	
	private static HashSet<BTreeNode<String>> bfs(BTreeNode<String> root, String needle) {
		List<BTreeNode<String>> haystack = new ArrayList<>();
		haystack.add(root);
		HashSet<BTreeNode<String>> results = new HashSet<>();
		List<BTreeNode<String>> newHayStack =new ArrayList<>();
		do {
			 results.addAll(haystack.stream()
			.filter((BTreeNode<String> node) -> node.getData().equals(needle))
			.collect(Collectors.toCollection(HashSet<BTreeNode<String>>::new)));
			
			newHayStack.clear();
			for(BTreeNode<String> node : haystack) {
				if(node.getLeftChild() != null) {
					newHayStack.add(node.getLeftChild());
				}
				if(node.getRightChild() != null) {
					newHayStack.add(node.getRightChild());
				}
			}
			haystack.clear();
			haystack.addAll(newHayStack);
		}while(!haystack.isEmpty());
		return results;
	}
	
}
