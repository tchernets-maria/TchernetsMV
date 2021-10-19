package polynom;

import automat.FSM;
import automat.RowTable;

public class Tree {

    static private int count;

    private int id;
    private Tree child00;
    private Tree child01;
    private Tree child10;
    private Tree child11;

    // Созадние дерева с присвоением порядкового номера
    public Tree() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    // Начальная инициализация
    static public void clear() {
        count = 0;
    }

    // Появление нового пути до листа в дереве
    static public void add(Tree tree, int x, int y, int k) {
        if (k == 0) {
            return;
        }
        int xOst = x % 2;
        int yOst = y % 2;
        x /= 2;
        y /= 2;
        k--;
        if (xOst == 0 && yOst == 0) {
            if (tree.child00 == null) {
                tree.child00 = new Tree();
            }
            add(tree.child00, x, y, k);
        } else if (xOst == 0 && yOst == 1) {
            if (tree.child01 == null) {
                tree.child01 = new Tree();
            }
            add(tree.child01, x, y, k);
        } else if (xOst == 1 && yOst == 0) {
            if (tree.child10 == null) {
                tree.child10 = new Tree();
            }
            add(tree.child10, x, y, k);
        } else {
            if (tree.child11 == null) {
                tree.child11 = new Tree();
            }
            add(tree.child11, x, y, k);
        }
    }

    public boolean equals(Tree tree) {
        if (this.child00 == null && tree.child00 != null
            || this.child01 == null && tree.child01 != null
            || this.child10 == null && tree.child10 != null
            || this.child11 == null && tree.child11 != null) {
            return false;
        }
        return true;
    }

    static public boolean equalsAll(Tree tree1, Tree tree2) {
        if (tree2 == null) {
            return true;
        }
        return tree1.equals(tree2)
                && equalsAll(tree1.child00, tree2.child00)
                && equalsAll(tree1.child01, tree2.child01)
                && equalsAll(tree1.child10, tree2.child10)
                && equalsAll(tree1.child11, tree2.child11);
    }

    static public void truncate(Tree tree, Tree treeCopy) {
        if (tree.child00 != null) {
            if (equalsAll(treeCopy, treeCopy.child00)) {
                tree.child00.id = tree.id;
                tree.child00.child00 = null;
                tree.child00.child01 = null;
                tree.child00.child10 = null;
                tree.child00.child11 = null;
            } else {
                truncate(tree.child00, treeCopy.child00);
            }
        }
        if (tree.child01 != null) {
            if (equalsAll(treeCopy, treeCopy.child01)) {
                tree.child01.id = tree.id;
                tree.child01.child00 = null;
                tree.child01.child01 = null;
                tree.child01.child10 = null;
                tree.child01.child11 = null;
            } else {
                truncate(tree.child01, treeCopy.child01);
            }
        }
        if (tree.child10 != null) {
            if (equalsAll(treeCopy, treeCopy.child10)) {
                tree.child10.id = tree.id;
                tree.child10.child00 = null;
                tree.child10.child01 = null;
                tree.child10.child10 = null;
                tree.child10.child11 = null;
            } else {
                truncate(tree.child10, treeCopy.child10);
            }
        }
        if (tree.child11 != null) {
            if (equalsAll(treeCopy, treeCopy.child11)) {
                tree.child11.id = tree.id;
                tree.child11.child00 = null;
                tree.child11.child01 = null;
                tree.child11.child10 = null;
                tree.child11.child11 = null;
            } else {
                truncate(tree.child11, treeCopy.child11);
            }
        }
    }

    public static void generateFSM(Tree tree, FSM fsm) {
        if (tree.child00 != null) {
            fsm.addRowStateTable(new RowTable(Integer.toString(tree.id), "0",
                    Integer.toString(tree.child00.id), "0"));
            generateFSM(tree.child00, fsm);
        }
        if (tree.child01 != null) {
            fsm.addRowStateTable(new RowTable(Integer.toString(tree.id), "0",
                    Integer.toString(tree.child01.id), "1"));
            generateFSM(tree.child01, fsm);
        }
        if (tree.child10 != null) {
            fsm.addRowStateTable(new RowTable(Integer.toString(tree.id), "1",
                    Integer.toString(tree.child10.id), "0"));
            generateFSM(tree.child10, fsm);
        }
        if (tree.child11 != null) {
            fsm.addRowStateTable(new RowTable(Integer.toString(tree.id), "1",
                    Integer.toString(tree.child11.id), "1"));
            generateFSM(tree.child11, fsm);
        }
    }
}
