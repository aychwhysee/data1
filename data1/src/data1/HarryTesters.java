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
        FiniteSet t6 = empty().add(13).add(18).add(15).add(21);
        FiniteSet t7 = empty().add(6).add(8).add(9);
        
        // Tests! Lots of tests!
        // Some tests actually test other methods (anything with t2 etc. tests
        // the add method, t5 tests union and such. Some tests will probably
        // be repeated in concept (is this what properties are???????)
        
        // cardinality tests
        System.out.println("=== Cardinality tests ===");
        System.out.println(mT.cardinality() + " should be " + 0);
        System.out.println(t1.cardinality() + " should be " + 1);
        System.out.println(t2.cardinality() + " should be " + 2);
        System.out.println(t3.cardinality() + " should be " + 1);
        System.out.println(t4.cardinality() + " should be " + 2);
        System.out.println(t5.cardinality() + " should be " + 5);
        
        // isEmptyHuh tests
        System.out.println("=== isEmptyHuh tests ===");
        System.out.println(mT.isEmptyHuh() + " should be " + true);
        System.out.println(t1.isEmptyHuh() + " should be " + false);
        System.out.println(t2.isEmptyHuh() + " should be " + false);
        System.out.println(t5.isEmptyHuh() + " should be " + false);
        
        // member tests (and I guess some union tests with t5)
        System.out.println("=== Member tests ===");
        System.out.println(mT.member(5) + " should be " + false);
        System.out.println(t1.member(6) + " should be " + true);
        System.out.println(t1.member(5) + " should be " + false);
        System.out.println(t2.member(5) + " should be " + true);
        System.out.println(t3.member(8) + " should be " + true);
        System.out.println(t4.member(8) + " should be " + true);
        System.out.println(t5.member(8) + " should be " + true);
        System.out.println(t5.member(8) + " should be " + true);
        System.out.println(t5.member(9) + " should be " + true);
        System.out.println(t5.member(7) + " should be " + true);
        System.out.println(t5.member(6) + " should be " + true);
        System.out.println(t5.member(5) + " should be " + true);
        System.out.println(t5.member(4) + " should be " + false);
        System.out.println(t6.member(18) + " should be " + true);
        
        // add tests (using booleans and ints to see if they're right)
        System.out.println("=== Add tests ===");
        System.out.println(mT.add(9).cardinality() + " should be " + 1);
        System.out.println(mT.add(9).member(9) + " should be " + true);
        System.out.println(t5.add(4).cardinality() + " should be " + 6);
        System.out.println(t1.add(10).cardinality() + " should be " + 2);
        System.out.println(t5.add(4).member(4) + " should be " + true);
        System.out.println(t5.add(12).member(9) + " should be " + true);
        System.out.println(t5.add(11).member(12) + " should be " + false);
        
        // remove tests
        System.out.println("=== Remove tests ===");
        System.out.println(t5.remove(5).cardinality() + " should be " + 4);
        System.out.println(t5.remove(5).member(5) + " should be " + false);
        System.out.println(t5.remove(5).member(6) + " should be " + true);
        System.out.println(t1.remove(6).cardinality() + " should be " + 0);
        System.out.println(t1.remove(6).isEmptyHuh() + " should be " + true);
        
        // union tests
        System.out.println("=== Union tests ===");
        System.out.println(mT.union(t2).cardinality() + " should be " + 2);
        System.out.println(mT.union(t5).union(t6).cardinality() + " should be " + 9);
        System.out.println(mT.union(mT).cardinality() + " should be " + 0);
        System.out.println(t1.union(mT).member(6) + " should be " + true);
        System.out.println(t1.union(t3).cardinality() + " should be " + 2);
        System.out.println(t1.union(t3).member(8) + " should be " + true);
        System.out.println(t1.union(t3).member(6) + " should be " + true);
        System.out.println(t1.union(t3).member(3) + " should be " + false);
        System.out.println(t5.union(t6).cardinality() + " should be " + 9);
        System.out.println(t5.union(t6).member(15) + " should be " + true);
        System.out.println(t5.union(t6).member(77) + " should be " + false);
        
        // inter tests
        System.out.println("=== Intersection tests ===");
        System.out.println(mT.inter(mT).cardinality() + " should be " + 0);
        System.out.println(t5.inter(mT).cardinality() + " should be " + 0);
        System.out.println(mT.inter(t5).cardinality() + " should be " + 0);
        System.out.println(t5.inter(t7).cardinality() + " should be " + 3);
        System.out.println(t5.inter(t7).member(6) + " should be " + true);
        System.out.println(t5.inter(t7).member(8) + " should be " + true);
        System.out.println(t5.inter(t7).member(9) + " should be " + true);
        System.out.println(t5.inter(t7).member(5) + " should be " + false);
        
        // diff tests
        System.out.println("=== Difference tests ===");
        System.out.println(t5.diff(mT).cardinality() + " should be " + 0);
        System.out.println(t5.diff(t6).cardinality() + " should be " + 4);
        System.out.println(t5.diff(t7).cardinality() + " should be " + 0);
        System.out.println(t5.diff(t6).member(18) + " should be " + true);
        System.out.println(t5.diff(t6).member(8) + " should be " + false);
        
        // equal tests
        System.out.println("=== Equal tests ===");
        System.out.println(mT.equal(mT) + " should be " + true);
        System.out.println(mT.equal(t1) + " should be " + false);
        System.out.println(t1.equal(t2) + " should be " + false);
        System.out.println(t1.equal(t1) + " should be " + true);
        System.out.println(t5.equal(t6) + " should be " + false);
        System.out.println(t5.union(t6).equal(t7) + " should be " + false);
        System.out.println(t5.equal(t7.add(5).add(7)) + " should be " + true);
        
        // subset tests
        System.out.println("=== Subset tests ===");
        System.out.println(t7.subset(t5) + " should be " + true);
        System.out.println(mT.subset(mT) + " should be " + true);
        System.out.println(mT.subset(t5) + " should be " + true);
        System.out.println(t5.subset(t7) + " should be " + false);
        
    } 
}
