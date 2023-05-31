package com.gyizer;

public class Main {
	
	public static String treeToParens(Tree tree) {
		
        if (tree instanceof Leaf) {
        	
            return "()";
            
        } else if (tree instanceof Branch) {
        	
            String leftParens = treeToParens(((Branch) tree).getLeft());
            String rightParens = treeToParens(((Branch) tree).getRight());
            
            return "(" + leftParens + rightParens + ")";
            
        } else {
        	
            return "";
            
        }
        
    }

    public static Tree parensToTree(String parens) {
    	
    	
    	int len = parens.length();
        int start = 0;
        int end = len - 1;

        if (len == 0 || parens.charAt(start) != '(' || parens.charAt(end) != ')') {
        	
            return null; 
        }

        start++;
        end--;

        while (start < len && parens.charAt(start) != '(' && parens.charAt(start) != ')') {
        	
            start++;
        }

        while (end >= 0 && parens.charAt(end) != '(' && parens.charAt(end) != ')') {
            end--;
        }

        if (start >= len || end < 0) {
            return null;
        }

        Tree left = parensToTree(parens.substring(start, end + 1));
        Tree right = parensToTree(parens.substring(end + 2, len - 1));

        if (left == null || right == null) {
            return null; 
        }

        return new Branch(left, right);


    }

    public static void main(String[] args) {
    	
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        
        Branch branch = new Branch(leaf1, leaf2);

        String parens = treeToParens(branch);
        
        System.out.println(parens); 

        Tree recreateTree = parensToTree(parens);
        System.out.println(recreateTree); 
    }
    
    
}









