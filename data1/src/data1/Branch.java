package data1;

public class Branch implements FiniteSet {
    int root;
    FiniteSet left;
    FiniteSet right;
    
    
    Branch (FiniteSet left, int root, FiniteSet right) {
        this.left = left;
        this.root = root;
        this.right = right;
    }
    
    public int cardinality() {
       return left.cardinality() + right.cardinality() + 1;
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
            return new Branch(left.add(elt), root, right);
        } else {
            return new Branch(left, root, right.add(elt));
        }
    }
    
    public FiniteSet remove(int elt) {
        this.remove(elt);
        return this;    
    }
    
    public FiniteSet union(FiniteSet u) {
        return left.union(right.union(u)).add(root);
    }
    
    public FiniteSet inter(FiniteSet u) {
        return this;
    }
    
    public FiniteSet diff(FiniteSet u) {
        return this;
    }
    
    public boolean equal(FiniteSet u) {
        return true;
    }
    
    public boolean subset(FiniteSet u) {
        return true;
    }
}
