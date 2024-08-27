import hjelpeklasser.Tabell;

//Lager Node-klassen med venstre, høyre og forelder, og en konstruktør som tar inn data.
class Node {
    Node left, right, parent;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = parent = null;
    }
}

// Binærsøketre-klassen med insert, delete og print funksjoner
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int[] tabell) {
//        root = null;
        for (int value : tabell) {
            insert(value);
        }
    }

    /////////////----MAIN METODE------//////////////////////
    public static void main(String[] args) {

        int[] tall = new int[]{50,30,20,40,70,60,80};
        BinarySearchTree tree = new BinarySearchTree(tall);
        tree.insert(90);

//        BinarySearchTree tree3 = new BinarySearchTree(tall);
//        tree.insert(tall);

        tree.printInorder();
        tree.printVisualTree();

        tree.search(80);

        tree.delete(80);

        tree.printInorder();
        tree.printVisualTree();

        BinarySearchTree tree2 = new BinarySearchTree(Tabell.randPerm(20));
//        tree2.printInorder();
        tree2.printVisualTree();

        System.out.println();
        tree2.search(10);
        tree2.insert(11);
        tree2.delete(10);

    }

    //    Sette inn data i noder
    void insert(int data) {
        root = insertData(root, data);
        System.out.println("Inserting data: " + data);
    }

    void insert(int[] array){
        for (int value : array) {
            insert(value);
        }
    }

    //    Inorder print funksjon
    void printInorder() {
        System.out.print("Printing tree Inorder: ");
        printInorderData(root);
    }

    void printInorderData(Node root) {
        if (root != null) {
            printInorderData(root.left);
            System.out.println(root.data + " ");
            printInorderData(root.right);
        }
    }

    Node insertData(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertData(root.left, data);
            root.left.parent = root;
        } else if (data > root.data) {
            root.right = insertData(root.right, data);
            root.right.parent = root;
        }
        return root;
    }

    //    Leter etter data i binærsøketreet
    public boolean search(int data) {
        System.out.println("Searching for data: " + data);
        boolean found = searchData(root, data);
        System.out.println(data + (found ? " found!" : " not found :("));
        return found;
    }

    private boolean searchData(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return data < root.data ? searchData(root.left, data) : searchData(root.right, data);
    }

    void delete(int data) {
        System.out.println("Deleting data: " + data);
        root = deleteData(root, data);
        System.out.println("Printing tree: ");
        printInorder();
        System.out.println();
    }

    private Node deleteData(Node root, int data) {
//        Hvis data ikke finnes
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteData(root.left, data);
        } else if (data > root.data) {
            root.right = deleteData(root.right, data);
        } else {
//            Noden som skal slettes er funnet

//            Alt 1: Noden har ett eller ingen barn.
            if (root.left == null) {
                Node temp = root.right;
                if (temp != null) {
                    temp.parent = root.parent;
                    return temp;
                }
            } else if (root.right == null) {
                Node temp = root.left;
                temp.parent = root.parent;
                return temp;
            }

//            Alt 2: Noden har to barn, finn minste verdi i høyre subtre.
            root.data = minValue(root.right);

//            Slett etterfølgeren
            root.right = deleteData(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return minValue(root.left);
        }
    }

    


    //    Funksjon for å printe et visuelt tre
    void printVisualTree() {
        int h = height(root);
        int maxNodes = (int) Math.pow(2, h) - 1; // Maksimalt antall noder på det nederste nivået

        System.out.println("\nVisuell representasjon: ");
        for (int i = 1; i <= h; i++) {
            int spaces = (int) Math.pow(2, h - i    ) - 1; // Beregn antall mellomrom før nodene på dette nivået
//            int spaces = (int) Math.pow(2, h-i) - 1; // Beregn antall mellomrom før nodene på dette nivået
            printThisLevel(root, i, maxNodes, spaces);
            System.out.println();
        }
    }

    void printThisLevel(Node root, int level, int maxNodes, int spaces) {
        if (root == null) {
            printSpaces(spaces * 2 + 1); // Skriv ut mellomrom for en manglende node
            return;
        }
        if (level == 1) {
            printSpaces(spaces);
            System.out.print(root.data);
            printSpaces(spaces);
        } else if (level > 1) {
            printThisLevel(root.left, level - 1, maxNodes, spaces);
            printThisLevel(root.right, level - 1, maxNodes, spaces);
        }
    }

    void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    int height(Node root) {
        if (root == null) return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            return (lheight > rheight) ? lheight + 1 : rheight + 1;
        }
    }
}