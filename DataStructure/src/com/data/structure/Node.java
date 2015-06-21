package com.data.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Singly linkedlist data structure
 * 
 * @author kerrigan
 */
public class Node {

	Node next = null;

	int data;

	public Node(int d) {
		this.data = d;
	}

	/**
	 * add Node
	 * 
	 * @param d
	 */
	public void appendToTail(int d) {
		Node endNode = new Node(d);
		Node n = this;
		while (null != n.next) {
			n = n.next;
		}
		n.next = endNode;
	}

	/**
	 * 
	 * @param node
	 * @param d
	 *            data value
	 * @return head Node
	 */
	public Node deleteNode(Node node, int d) {
		Node n = node;
		// if the node is head of node data, forward to next
		if (n.data == d) {
			return n.next;
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return n;
			}
			n = n.next;
		}
		return n;
	}

	/**
	 * remove Duplicate node
	 * @param node
	 * @return head node
	 */
	public Node deleteDuplicateNode(Node node) {
		final Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		Node previous = null;
		while (node.next != null) {
			if (map.containsKey(node.data)) {
				previous.next = node.next;
			} else {
				map.put(node.data, true);
				previous = node.next;
			}
			node = node.next;
		}
		return previous;
	}

	/**
	 * select specific node by index
	 * @param headNode
	 * @param k index
	 * @return i index
	 */
	public static int selectedSpecificNode(Node headNode, int k) {
		if (null == headNode) {
			return 0;
		}
		int i = selectedSpecificNode(headNode.next, k) + 1;
		if (i == k) {
			System.out.print(headNode.data);
		}
		return i;
	}
	
	public final static void main(final String[] arg){
		Node headNode = new Node(1);
		headNode.appendToTail(2);
		headNode.appendToTail(3);
		headNode.appendToTail(4);
		Node.selectedSpecificNode(headNode, 2);
	}
}
