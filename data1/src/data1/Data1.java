package data1;

// A list is either...empty or has at least one thing in it.
// For at least one thing -> what is the thing? what's after it?
// length function for list interface

// a tree is either
// - leaf (empty)
// - branch
//      - left : tree
//      - root : T
//      - right : tree



interface FiniteSet {
    public int cardinatliy();
    public boolean isEmptyHuh();
    public boolean member(int elt);
    public FiniteSet add(int elt);
    public FiniteSet remove(int elt);
    public FiniteSet union(FiniteSet u);
    public FiniteSet inter(FiniteSet u);
    public FiniteSet diff(FiniteSet u);
    public boolean equal(FiniteSet u);
    public boolean subset(FiniteSet u);
}

public class leaf implements FiniteSet {
    
    public int cardinality () {
        return 0;
    }
    
    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(int elt) {
        return false;
    }

    public FiniteSet add(int elt) {
        return new branch(this, elt, this);
    }
    
    public FiniteSet remove(int elt) {
        return this;
    }
    
    public FiniteSet union(FiniteSet u) {
        return u;
    }
    
    public FiniteSet inter(FiniteSet u) {
        return this;
    }
    
    public FiniteSet diff(FiniteSet u) {
        return this;
        // Return the empty set? or null? since u contains the empty set too...
    }
    
    public boolean equal(FiniteSet u) {
        if (u == this) {
            return true;
        } else return false;
    }
    
    public boolean subset(FiniteSet u) {
        return true;
    }
    
    public static void main(String[] args) {
        
    }
    
}

public class branch implements FiniteSet {
    int root;
    FiniteSet left;
    FiniteSet right;
    
    
    branch (FiniteSet left, int root, FiniteSet right) {
        this.left = left;
        this.root = root;
        this.right = right;
    }
    
    public int cardinality () {
       return left.cardinatliy() + right.cardinatliy() + 1;
    }
    
    public boolean isEmptyHuh() {
        return false;
    }
    
    public boolean member(int elt) {
        if (root == elt) {
            return true;
        } else if (elt < root) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }
    
    public FiniteSet add(int elt) {
        if (root == elt) {
           return this;
        } else if (elt < root) {
            return left.add(elt);
        } else {
            return right.add(elt);
        }
    }
}
