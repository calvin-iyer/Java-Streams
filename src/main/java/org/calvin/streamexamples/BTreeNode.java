package org.calvin.streamexamples;

/**
 * @author CalvinI
 *
 */
public class BTreeNode<T> {
	
	private BTreeNode<T> leftChild;
	
	private BTreeNode<T> rightChild;
	
	private T data;

	public BTreeNode(T data) {
		this.data = data;
	}

	public BTreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BTreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BTreeNode other = (BTreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BTreeNode [leftChild=" + leftChild + ", rightChild=" + rightChild + ", data=" + data + "]";
	}
	
}
