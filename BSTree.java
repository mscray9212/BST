import java.util.*;
class BSTree {

		    private static class Node {
			@SuppressWarnings("rawtypes")
			Comparable item;
			Node left;
			Node right;
			@SuppressWarnings("rawtypes")
			public Node(Comparable item) {
			    this.item = item;
			    left = null;
			    right = null;
			}
		    }
		 
		    private static Node root;
		    @SuppressWarnings("rawtypes")
			public Comparable find(Comparable x) {
			return find(root, x);
		    }
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			private Comparable find(Node t, Comparable x) {
			while (t != null)
			    if (x.compareTo(t.item) < 0)
				t = t.left;
			    else if (x.compareTo(t.item) > 0)
				t = t.right;
			    else
				return t.item;
			return null;
		    }
		    @SuppressWarnings("rawtypes")
			public Comparable findMin() {
			return findMin(root);
		    }
		    @SuppressWarnings("rawtypes")
			private Comparable findMin(Node t) {
			if (t != null) {
			    while (t.left != null)
				t = t.left;
			    return t.item;
			}
			return null;
		    }
		    @SuppressWarnings("rawtypes")
			public Comparable findMax() {
			return findMax(root);
		    }
		    @SuppressWarnings("rawtypes")
			private Comparable findMax(Node t) {
			if (t != null) {
			    while (t.right != null)
				t = t.right;
			    return t.item;
			}
			return null;
		    }
		    @SuppressWarnings("rawtypes")
			public void insert(Comparable x) {
			root = insert(root, x);
		    }
		    @SuppressWarnings({ "rawtypes", "unchecked" })
			private Node insert(Node t, Comparable x) {
			if (t == null)
			    t = new Node(x);
			else if (x.compareTo(t.item) < 0)
			    t.left = insert(t.left, x);
			else if (x.compareTo(t.item) > 0)
			    t.right = insert(t.right, x);
			return t;
		    }
		    @SuppressWarnings("rawtypes")
			public void remove(Comparable x) {
			root = remove(root, x);
		    }
		    @SuppressWarnings("unchecked")
			private Node remove(Node t, @SuppressWarnings("rawtypes") Comparable x) {
			if (t != null) {
			    if (x.compareTo(t.item) < 0)
				t.left = remove(t.left, x);
			    else if (x.compareTo(t.item) > 0)
				t.right = remove(t.right, x);
			    else if (t.left == null)
				t = t.right;
			    else if (t.right == null)
				t = t.left;
			    else {
				t.item = findMin(t.right);
				t.right = remove(t.right, t.item);
			    }
			}
			return t;
		    }
		 
		    private void indent(int depth, Node node) {
			for (int i = 0; i < depth; i++)
			    System.out.print("   ");
			System.out.println(node.item);
		    }
		    private void inorder() {
			inorder(root, 0);
		    }
		    private void inorder(Node node, int depth) {
			if (node != null) {
			    inorder(node.right, depth+1);
			    indent(depth, node);
			    inorder(node.left, depth+1);
			}
		    }
		 
		    public static BSTree makeTree(String[] items) {
			BSTree tree = new BSTree();
			for (int i = 0; i < items.length; i++)
			    tree.insert(items[i]);
			return tree;
		    }
		    
		    public static String getAll(String[] items){
		    	BSTree tree = new BSTree();
		    	String item = "";
		    	for(int i = 0; i < items.length; i++){
		    		tree.insert(items[i]);
		    	item += items[i];
		    	}
		    	return item;
		    }
		    public static String[] getAlpha(String items){
		    	String item[] = new String[50];
		    	for(int i = 0; i < 100; i+=2){
		    		item[i/2] = items.substring(i,i+2);
		    	}
		    	/*for(int i = 0; i < 50; i++){
		    		for(int j = 0; j < 50; j++){
		    			if(Integer.parseInt(item[i]) > Integer.parseInt(item[j])){
		    				temp = item[j];
		    				item[i] = item[j];
		    			}
		    		}
		    	}*/
		    	//for(int i = 0; i < 50; i++){
		    	//System.out.print(item[i] +" ");
		    	//}
		    	Arrays.sort(item);
		    	return item;
		    }
		    public static void testTree(BSTree tree) {
		    	
			System.out.println("Binary Search Tree: ");
			System.out.println();
			tree.inorder();
			System.out.println();
		    }
		    public static int randomGen(){
		    	Random r = new Random();
		    	int k = r.nextInt(99)+1;
		    	return k;
		    }
		    
		    public static String[] getValues(String[] a){
		    	String[] i = a;
		    	int[] nums = new int[50];
		    	for(int j = 0; j < 50; j++){
		    		i[j] = Integer.toString(randomGen());
		    		nums[j] = Integer.parseInt(i[j]);
		    		if(nums[j] < 10){
		    			i[j] = "0"+i[j];
		    		}
		    	}
		    	return i;
		    }

		    public static void printValues(String[] a){
		    	String[] i = a;
		    	for(int k = 0; k < 10; k++){
		    		System.out.printf(i[k] + " ");
		    	}
		    	System.out.println();
		    	for(int l = 10; l < 20; l++){
		    		System.out.print(i[l] + " ");
		    	}
		    	System.out.println();
		    	for(int m = 20; m < 30; m++){
		    		System.out.print(i[m] + " ");
		    	}
		    	System.out.println();
		    	for(int n = 30; n < 40; n++){
		    		System.out.print(i[n] + " ");
		    	}
		    	System.out.println();
		    	for(int o = 40; o < 50; o++){
		    		System.out.print(i[o] + " ");
		    	}
		    	System.out.println();
		    	System.out.println();
		    }

		    public static void main(String[] args) {
		    	String[] i = new String[50];
		    	getValues(i);
		    	System.out.println("50 randomly generated numbers: ");
		    	System.out.println();
		    	printValues(i);

		    	BSTree tree = makeTree(i);
		    	testTree(tree);
			
		    	System.out.println("Small to large: ");
		    	System.out.println();
		    	printValues(getAlpha(getAll(i)));
		    }
		}