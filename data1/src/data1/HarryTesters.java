package data1;

class HarryTesters {
        public static void main(String[] args) {
        FiniteSet mT = new Leaf();
        FiniteSet t1 = new Branch(mT, 5, mT);
        FiniteSet t2 = new Branch(t1, 7, mT);
        System.out.println(mT.cardinality() + " should be " + 0);
        System.out.println(t1.cardinality() + " should be " + 1);
        System.out.println(t2.cardinality() + " should be " + 2);
        System.out.println(t1.add(7).member(7) + " should be " + true);
        System.out.println(t1.add(7).member(6) + " should be " + false);
        System.out.println(t1.add(3).member(3) + " should be " + true);
        System.out.println(t2.add(6).member(6) + " should be " + true);
        System.out.println(t2.add(6).member(5) + " should be " + true);
        System.out.println(mT.isEmptyHuh() + " should be " + true);
        System.out.println(t1.isEmptyHuh() + " should be " + false);
        System.out.println(t1.add(7).isEmptyHuh() + " should be " + false);
        
    } 
}
