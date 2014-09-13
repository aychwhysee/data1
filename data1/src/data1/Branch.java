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
        if (root == elt) {
            return left.union(right);
        } else if (elt < root) {
            return new Branch(left.remove(elt), root, right);
        } else {
            return new Branch(left, root, right.remove(elt));
        }
    }
    
    public FiniteSet union(FiniteSet u) {
        return left.union(right.union(u)).add(root);
    }
    
    public FiniteSet inter(FiniteSet u) {
        if (u.member(this.root)) {
            return new Branch(left.inter(u), root, right.inter(u));
        } else {
            return left.inter(u).union(right.inter(u));
        }
    }
    
    public FiniteSet diff(FiniteSet u) {
        if (u.member(root)) {
            return left.union(right.union(u.remove(root)));
        } else {
            return right.diff(u).union(left.diff(u));
        }
    }
    
    public boolean equal(FiniteSet u) {
        return this.subset(u) && u.subset(this);
    }
    
    public boolean subset(FiniteSet u) {
        if(!u.member(root)) {
            return false;
        } else if ((this.left.isEmptyHuh()) || (this.right.isEmptyHuh())) {
            return true;
        } else {
            return this.left.union(this.right).subset(u);
        }
    }
}
