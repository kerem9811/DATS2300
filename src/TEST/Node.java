package TEST;

import hjelpeklasser.Tabell;

import java.util.Arrays;

class Node {
    int data;
    Node left, right, parent;

    public Node(int item) {
        data = item;
        left = right = parent = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int[] tabell) {
        for (int value : tabell) {
            insert(value);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.printLevelOrder();

        tree.delete(40);

        tree.printLevelOrder();

        int[] numbers = Tabell.randPerm(20);
        System.out.println(Arrays.toString(numbers));
        BinarySearchTree tree2 = new BinarySearchTree(Tabell.randPerm(20));
        tree2.printLevelOrder();

    }

    // Metode for å legge inn et nytt element i treet (ignorerer duplikater)
    void insert(int data) {
        System.out.println("Setter inn: " + data);
        root = insertRec(root, data);
        System.out.println("Treet etter innsetting:");
        inorder(); // Skriver ut treet etter innsetting
        System.out.println();
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
            root.left.parent = root; // Oppdater forelder
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
            root.right.parent = root; // Oppdater forelder
        } // Ignorer duplikater (data == root.data)

        return root;
    }

    // Metode for å søke etter et element i treet
    public boolean search(int data) {
        System.out.println("Søker etter: " + data);
        boolean found = searchRec(root, data);
        System.out.println(data + (found ? " ble funnet." : " ble ikke funnet."));
        return found;
    }

    boolean searchRec(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;

        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // Metode for å slette et element fra treet
    void delete(int data) {
        System.out.println("Sletter: " + data);
        root = deleteRec(root, data);
        System.out.println("Treet etter sletting:");
        inorder(); // Skriver ut treet etter sletting
        System.out.println();
    }

    Node deleteRec(Node root, int data) {
        if (root == null) return root;

        if (data < root.data) root.left = deleteRec(root.left, data);
        else if (data > root.data) root.right = deleteRec(root.right, data);
        else {
            // Noden som skal slettes er funnet

            // Tilfelle 1: Noden har ingen eller ett barn
            if (root.left == null) {
                Node temp = root.right;
                if (temp != null) temp.parent = root.parent; // Oppdater forelder hvis det finnes et høyre barn
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                temp.parent = root.parent; // Oppdater forelder
                return temp;
            }

            // Tilfelle 2: Noden har to barn. Finn etterfølgeren (minste verdi i høyre subtre)
            root.data = minValue(root.right);

            // Slett etterfølgeren
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Forenklet minValue med rekursjon
    int minValue(Node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return minValue(root.left);
        }
    }

    // Metode for å skrive ut treet i inorder-rekkefølge (sortert rekkefølge)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    void printLevelOrder() {
        int h = height(root);
        int maxNodes = (int) Math.pow(2, h) - 1; // Maksimalt antall noder på det nederste nivået

        System.out.println("\nVisuell representasjon: ");
        for (int i = 1; i <= h; i++) {
            int spaces = (int) Math.pow(2, h - i + 1) - 1; // Beregn antall mellomrom før nodene på dette nivået
            printGivenLevel(root, i, maxNodes, spaces);
            System.out.println();
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

    void printGivenLevel(Node root, int level, int maxNodes, int spaces) {
        if (root == null) {
            printSpaces(spaces * 2 + 1); // Skriv ut mellomrom for en manglende node
            return;
        }
        if (level == 1) {
            printSpaces(spaces);
            System.out.print(root.data);
            printSpaces(spaces);
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1, maxNodes, spaces);
            printGivenLevel(root.right, level - 1, maxNodes, spaces);
        }
    }

    void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}