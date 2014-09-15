package data1;

class HarryTesters {
    
    public static FiniteSet empty() {
        return new Leaf();
    }
    
        public static void main(String[] args) {
            // Empty set
        FiniteSet mT = empty();
        // Left branches
        //FiniteSet t1 = new Branch(mT, 6, mT);
        FiniteSet t1 = empty().add(6);
        //FiniteSet t2 = new Branch(mT, 5, t1);
        FiniteSet t2 = t1.add(5);
        // Right branches
        //FiniteSet t3 = new Branch(mT, 8, mT);
        FiniteSet t3 = empty().add(8);
        //FiniteSet t4 = new Branch(t3, 9, mT);
        FiniteSet t4 = t3.add(9);
        // Combined branch with root = 7
        //FiniteSet t5 = new Branch(t2, 7, t4);
        FiniteSet t5 = t2.union(t4).add(7);
        
        // Tests! Lots of tests!
        
        // Cardinality tests
        System.out.println(mT.cardinality() + " should be " + 0);
        System.out.println(t1.cardinality() + " should be " + 1);
        System.out.println(t2.cardinality() + " should be " + 2);
        System.out.println(t3.cardinality() + " should be " + 1);
        System.out.println(t4.cardinality() + " should be " + 2);
        System.out.println(t5.cardinality() + " should be " + 5);
    } 
}
