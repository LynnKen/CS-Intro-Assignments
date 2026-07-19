public class TestToString {
    public static void main(String[] args) {
		//TODO
        BinaryTree<Integer> emptyTree =new BinaryTree<>();
        testEmpty(emptyTree);
        test1(emptyTree);
        test2(emptyTree);
        test3(emptyTree);
        test4(emptyTree);
        test5(emptyTree);
//        BinaryTree<Integer> tree1=new BinaryTree<>();
//        tree1.insert(1);
//        tree1.insert(2);
//        BinaryTree<Integer> tree2=new BinaryTree<>();
//        tree2.insert(1);
//        tree2.insert(2);
//        BinaryTree<Integer> tree3=new BinaryTree<>();
//        tree3.insert(2);
//        tree3.insert(4);
//        tree3.insert(6);
//        tree3.insert(8);
//        tree3.insert(10);
//
//        System.out.println(emptyTree);
//        System.out.println(tree1);
//        System.out.println(tree2);
//        //BinaryTreeInOrderIterator<Integer> itr=new BinaryTreeInOrderIterator<>(tree3.root);
//        Iterator<Integer> itr= tree3.iterator();
//        Iterator<Integer> BFS=new BinaryTreeBFSIterator<>(tree3.root);
//        String st="";
//        String st2="";
//        while (itr.hasNext())
//            st=st+itr.next();
//        while (BFS.hasNext())
//            st2=st2+BFS.next();
//        System.out.println(st);
//        System.out.println(st2);
//        System.out.println(tree3.toString());
//        printByLevels(tree3);


    }
    public static <T extends Comparable<T>> void checkPass(T ob1,T ob2){
        if (ob1.compareTo(ob2)==0)
            System.out.println("pass");
        else
            System.out.println("failed");
    }
    public static void testEmpty(BinaryTree<Integer> tree){
        String s1 =tree.toString();
        System.out.print("testEmpty:");
        checkPass(s1,"Empty Tree");
    }
    //not-even
    public static void test1(BinaryTree<Integer> tree){
        tree.root=new BinaryNode<>(1);
        tree.root.left=new BinaryNode<>(2);
        String s1 =tree.toString();
        System.out.print("test1:");
        checkPass(s1,"tree((2),1)");
    }
    //massive tree
    public static void test2(BinaryTree<Integer> tree){
        tree.root=new BinaryNode<>(0);
        BinaryNode nodeR=new BinaryNode<>(2);
        nodeR.right=new BinaryNode(4);
        nodeR.left=new BinaryNode(6);
        BinaryNode nodeL=new BinaryNode<>(1);
        nodeL.right=new BinaryNode(3);
        nodeL.left=new BinaryNode<>(5);
        tree.root.left=nodeL;
        tree.root.right=nodeR;
        System.out.print("test2:");
        checkPass(tree.toString(),"tree(((5),1,(3)),0,((6),2,(4)))");
    }
    //just left sons
    public static void test3(BinaryTree<Integer> tree){
        tree.root=new BinaryNode<>(0);
        tree.root.left=new BinaryNode<>(1);
        tree.root.left.left=new BinaryNode<>(2);
        System.out.print("test3:");
        checkPass(tree.toString(),"tree(((2),1),0)");
    }
    //just right sons
    public static void test4(BinaryTree<Integer> tree){
        tree.root=new BinaryNode<>(0);
        tree.root.right=new BinaryNode<>(1);
        tree.root.right.right=new BinaryNode<>(2);
        System.out.print("test4:");
        checkPass(tree.toString(),"tree(0,(1,(2)))");
    }
    //one element
    public static void test5(BinaryTree<Integer> tree) {
        tree.root = new BinaryNode<>(0);
        System.out.print("test5:");
        checkPass(tree.toString(),"tree(0)");
    }
    public static <T> void printByLevels(BinaryTree<T> binaryTree){
        Queue<BinaryNode<T>> queue = new QueueAsLinkedList<>();
        queue.enqueue(binaryTree.root);

        while (!queue.isEmpty()){
            int nodesInLevel=((QueueAsLinkedList<BinaryNode<T>>)queue).size();

            for (int i=0;i<nodesInLevel;i++){
                BinaryNode<T> pointer=queue.dequeue();
                System.out.print(pointer.data+" ");

                if (pointer.left!=null)
                    queue.enqueue(pointer.left);
                if (pointer.right!=null)
                    queue.enqueue(pointer.right);
            }
            System.out.println();
        }
    }
}
