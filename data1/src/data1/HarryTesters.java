package data1;

class HarryTesters {
        public static void main(String[] args) {
        FiniteSet mT = new Leaf();
        FiniteSet t1 = new Branch(mT, 5, mT);
        FiniteSet t2 = new Branch(t1, 7, mT);
        System.out.println(t1.cardinality() + " should be " + 1);
        System.out.println(t2.cardinality() + " should be " + 2);
    } 
}
