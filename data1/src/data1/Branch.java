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
        // Counting! Count the stuff on the left and the stuff on the right
        // then add one for the root.
       return left.cardinality() + right.cardinality() + 1;
    }
    
    public boolean isEmptyHuh() {
        // Branch is never empty, return false.
        return false;
    }
    
    public boolean member(int elt) {
        // Check if elt is = to root. If it is, return true. If it's not, check
        // if it's smaller or greater than root, and check the respective sides
        // of the branch.
        if (root == elt) {
            return true;
        } else if (elt < root) {
            return left.member(elt);
        } else {
            return right.member(elt);
        }
    }
    
    public FiniteSet add(int elt) {
        // If elt is already in the branch, just return the branch as it is.
        // If not, find where it should go and add it there.
        if (root == elt) {
           return this;
        } else if (elt < root) {
            return new Branch(left.add(elt), root, right);
        } else {
            return new Branch(left, root, right.add(elt));
        }
    }
    
    public FiniteSet remove(int elt) {
        // If elt is = root, then get rid of it by only returning the union of
        // left and right.
        // If not, check the respective sides of the branch depending on if elt
        // is lesser or greater than root.
        if (root == elt) {
            return left.union(right);
        } else if (elt < root) {
            return new Branch(left.remove(elt), root, right);
        } else {
            return new Branch(left, root, right.remove(elt));
        }
    }
    
    public FiniteSet union(FiniteSet u) {
        // Add method helps to get rid of duplicates in our set.
        return left.union(right.union(u)).add(root);
    }
    
    public FiniteSet inter(FiniteSet u) {
        // If root is a member of FiniteSet u, then we put root into our
        // intersection set and basically do that for the rest of the elements
        // in our set. Then we return our new set altogether.
        if (u.member(root)) {
            return new Branch(left.inter(u), root, right.inter(u));
        } else {
            return left.inter(u).union(right.inter(u));
        }
    }
    
    public FiniteSet diff(FiniteSet u) {
        // If root is a member of u, don't include it in our new tree.
        if (u.member(root)) {
         //   return left.union(right.union(u.remove(root)).diff(u));
            return left.union(right).diff(u.remove(root));
        //    return u.remove(root).union(left.union(right).diff(u));
        } else {
            // Check the rest and put it all together in the end (needs testing)
        //    return right.diff(u).union(left.diff(u));
            return left.union(right).diff(u);
        }
    }
    
    public boolean equal(FiniteSet u) {
        // Two sets are equal iff they are subsets of each other.
        return this.subset(u) && u.subset(this);
    }
    
    public boolean subset(FiniteSet u) {
        // If root is not a member of u, then t cannot be a subset of u.
        if(!u.member(root)) {
            return false;
            // Check everything else.
        } else {
            return this.left.union(this.right).subset(u);
        }
    }
}
