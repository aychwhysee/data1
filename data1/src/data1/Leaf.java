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

public class Leaf implements FiniteSet {
    Leaf() {};
    
    public int cardinality() {
        return 0;
    }
    
    public boolean isEmptyHuh() {
        return true;
    }
    
    public boolean member(int elt) {
        return false;
    }

    public FiniteSet add(int elt) {
        return new Branch(this, elt, this);
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
        return u;
    }
    
    public boolean equal(FiniteSet u) {
        return u.isEmptyHuh();
    }
    
    public boolean subset(FiniteSet u) {
        return true;
        // since an empty set is also a subset of a set?
    }
}
