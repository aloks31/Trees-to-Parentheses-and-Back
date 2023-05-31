package com.gyizer;

public class Branch extends Tree {
	
	private Tree left;
    private Tree right;

    public Branch(Tree left, Tree right) {
        this.left = left;
        this.right = right;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

}
