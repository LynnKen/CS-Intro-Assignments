public class TestBalance {
    public static void main(String[] args) {
        //TODO
        BankAccountsBinarySearchTree tree=new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
        testEmptyTree(tree);
        tree.clear();
        testBalance1(tree);
        tree.clear();
        testBalance2(tree);
        tree.clear();
        testBalance3(tree);
        tree.clear();
    }
    public static void testEmptyTree(BankAccountsBinarySearchTree tree){
        System.out.print("test Empty: before balance: ");
        TestToString.checkPass(tree.toString(),"Empty Tree");
        tree.balance();
        System.out.print("test Empty: after balance: ");
        TestToString.checkPass(tree.toString(),"Empty Tree");
    }
    //all left sons
    public static void testBalance1(BankAccountsBinarySearchTree tree1){
        tree1.insert(new BankAccount("5",5,5));
        tree1.insert(new BankAccount("4",4,4));
        tree1.insert(new BankAccount("3",3,3));
        tree1.insert(new BankAccount("2",2,2));
        tree1.insert(new BankAccount("1",1,1));
        System.out.print("test balance 1: before balance: ");
        checkPass(tree1,"tree(((((1),2),3),4),5)");
        tree1.balance();
        System.out.print("test balance 1: after balance: ");
        checkPass(tree1,"tree((1,(2)),3,(4,(5)))");
    }
    //all right sons
    public static void testBalance2(BankAccountsBinarySearchTree tree){
        tree.insert(new BankAccount("1",1,1));
        tree.insert(new BankAccount("2",2,2));
        tree.insert(new BankAccount("3",3,3));
        tree.insert(new BankAccount("4",4,4));

        System.out.print("test balance 2: before balance: ");
        checkPass(tree,"tree(1,(2,(3,(4))))");
        tree.balance();
        System.out.print("test balance 2: after balance: ");
        checkPass(tree,"tree((1),2,(3,(4)))");
    }
    //massive tree
    public static void testBalance3(BankAccountsBinarySearchTree tree){
        tree.insert(new BankAccount("5",5,0));
        tree.insert(new BankAccount("4",4,0));
        tree.insert(new BankAccount("3",3,0));
        tree.insert(new BankAccount("6",6,0));
        tree.insert(new BankAccount("9",9,0));
        tree.insert(new BankAccount("7",7,0));
        tree.insert(new BankAccount("1",1,0));
        tree.insert(new BankAccount("2",2,0));
        tree.insert(new BankAccount("8",8,0));
        System.out.print("test balance 3: before balance: ");
        checkPass(tree,"tree((((1,(2)),3),4),5,(6,((7,(8)),9)))");
        tree.balance();
        System.out.print("test balance 3: after balance: ");
        checkPass(tree,"tree(((1),2,(3,(4))),5,((6),7,(8,(9))))");
    }
    //check if the tree String match to expected
    public static void checkPass(BankAccountsBinarySearchTree tree,String expected){
        BinarySearchTree<Integer> convertedToInt=copyBankAccountTreeToInteger(tree);
        TestToString.checkPass(convertedToInt.toString(),expected);
    }
    //convers BankAccount tree to int tree (based on account number)
    public static BinarySearchTree<Integer> copyBankAccountTreeToInteger(BankAccountsBinarySearchTree tree){
        BinarySearchTree<Integer> result = new BinarySearchTree<>(new IntegerComparator());
        if (!tree.isEmpty()){
            result.root =copyBankAccountTreeToInteger((BinarySearchNode<BankAccount>)tree.root);
        }
        return result;
    }
    public static BinaryNode<Integer> copyBankAccountTreeToInteger(BinarySearchNode<BankAccount> node){
        if (node==null)
            return null;
        BinaryNode<Integer> result=new BinarySearchNode<>(node.data.getAccountNumber(),new IntegerComparator());
        if (node.left!=null)
            result.left=copyBankAccountTreeToInteger((BinarySearchNode<BankAccount>)node.left);
        if (node.right!=null)
            result.right=copyBankAccountTreeToInteger((BinarySearchNode<BankAccount>)node.right);
        return result;

    }


}
