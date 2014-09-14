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
        // Leaf is always empty, return 0
        return 0;
    }
    
    public boolean isEmptyHuh() {
        // Leaf is always empty, return true
        return true;
    }
    
    public boolean member(int elt) {
        // Leaf is always empty (no members), return false
        return false;
    }

    public FiniteSet add(int elt) {
        // Since Leaf is empty, we just need to make a new Branch
        // with elt as the only element in the set
        return new Branch(this, elt, this);
    }
    
    public FiniteSet remove(int elt) {
        // Removing from an empty set should just return our original empty set
        return this;
    }
    
    public FiniteSet union(FiniteSet u) {
        // Since leaf is empty, just return u
        return u;
    }
    
    public FiniteSet inter(FiniteSet u) {
        // The intersection of an empty set and anything is just the empty set
        return this;
    }
    
    public FiniteSet diff(FiniteSet u) {
        // The difference between a set U and an empty set is just U
        return u;
    }
    
    public boolean equal(FiniteSet u) {
        // If u is empty, then it is equal to this. Else false.
        return u.isEmptyHuh();
    }
    
    public boolean subset(FiniteSet u) {
        // An empty set is always a subset of another set.
        return true;
    }
}
