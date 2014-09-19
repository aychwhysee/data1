package data1;

import java.util.Random;

class HarryTesters {

    public static FiniteSet empty() {
        return new Leaf();
    }

    static Random rand = new Random();

    public static int randomInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public static FiniteSet randomSet(int min, int max, int length) {
        if (length > 0) {
            return randomSet(min, max, (length - 1)).add(randomInt(min, max));
        } else {
            return empty();
        }
    }

    // Properties-
    // Add and Cardinality
    public static void addCardP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet mySet = randomSet(0, 100, 10);
            int currentCard = mySet.cardinality();
            int random = randomInt(0, 100);
            if (mySet.member(random)) {
                if (mySet.add(random).cardinality() == currentCard + 1) {
                    System.out.println("Wrongly added");
                }
            } else {
                if (mySet.add(random).cardinality() == currentCard) {
                    System.out.println("Not added at all");
                }
            }
        }
    }

    // Cardinality and Remove
    public static void removeCardP() {

        for (int i = 0; i < 50; i++) {
            FiniteSet mySet = randomSet(0, 100, 10);
            int currentCard = mySet.cardinality();
            int random = randomInt(0, 100);
            if (mySet.remove(random).cardinality() == currentCard
                    || mySet.remove(random).cardinality() == currentCard - 1) {

            } else {
                System.out.println("Something is wrong");
            }
        }
    }

    // Add and Member
    public static void addMemberP() {
        for (int i = 0; i < 50; i++) {
            int x = randomInt(0, 100);
            int y = randomInt(0, 100);
            FiniteSet mySet = randomSet(0, 100, 10);
            if (mySet.add(x).member(y)) {
                if (x == y || mySet.member(y)) {
                    // then it works
                } else {
                    System.out.println("Something is wrong");
                }
            } else {
                if (x == y || mySet.member(y)) {
                    System.out.println("Something is wrong");
                }
            }
        }
    }

    // Remove and Member
    public static void removeMemberP() {
        for (int i = 0; i < 50; i++) {
            int x = randomInt(0, 100);
            FiniteSet mySet = randomSet(0, 100, 10);
            if (mySet.member(x)) {
                if (mySet.remove(x).cardinality() != mySet.cardinality() - 1) {
                    System.out.println("Nope");
                }
            } else {
                if (mySet.remove(x).cardinality() != mySet.cardinality()) {
                    System.out.println("Nope");
                }
            }
        }
    }

    // Difference and isEmptyHuh
    public static void diffEmptyHuhP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet sX = randomSet(0, 30, 10);
            FiniteSet sY = randomSet(31, 60, 10);
            FiniteSet sZ = sX.union(sY);
            if (!(sZ.diff(sX).isEmptyHuh())) {
                System.out.println("Nope");
            }
            if (sX.diff(sY).isEmptyHuh() || sY.diff(sX).isEmptyHuh()) {
                System.out.println("Nope");
            }
        }
    }

    // isEmptyHuh and Empty
    public static void isEmptyHuhEmptyP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet mySet = randomSet(0, 100, 10);
            FiniteSet mT = empty();
            if (!mT.isEmptyHuh()) {
                System.out.println("Nope.");
            } else {
                if (mySet.isEmptyHuh()) {
                    System.out.println("Nope.");
                }
            }
        }
    }

    // Difference and Member
    public static void diffMemberP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet mySet = randomSet(0, 100, 10);
            FiniteSet otherSet = randomSet(0, 100, 10);
            int x = randomInt(0, 100);
            if (mySet.diff(otherSet).member(x)) {
                if (!otherSet.member(x) || mySet.member(x)) {
                    System.out.println("Nope!!!!");
                }
            } else if (!otherSet.member(x) || mySet.member((x))) {

            } else {
                System.out.println("Nope!!!!");
            }
        }
    }

    // Subset and Union
    public static void subsetUnionP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet sX = randomSet(0, 30, 10);
            FiniteSet sY = randomSet(31, 60, 10);
            FiniteSet sZ = randomSet(61, 90, 10);
            if (sX.union(sY).subset(sZ) != sX.subset(sZ) && sY.subset(sZ)) {
                System.out.println("Nope!");
            }
        }
    }

    // Inter, Union, and Equal
    public static void interUnionEqualP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet sX = randomSet(0, 100, 10);
            FiniteSet sY = randomSet(0, 100, 10);
            FiniteSet sZ = sX.union(sY);
            if (!sX.inter(sZ).equal(sX) || !sY.inter(sZ).equal(sY)) {
                System.out.println("No!!!!");
            }
        }
    }

    // Member and Union
    public static void memberUnionP() {
        for (int i = 0; i < 50; i++) {
            FiniteSet mySet = randomSet(0, 100, 10);
            FiniteSet otherSet = randomSet(0, 100, 10);
            int x = randomInt(0, 100);
            if (mySet.union(otherSet).member(x)) {
                if (mySet.member(x) || otherSet.member(x)) {
                } else {
                    System.out.println("No!");
                }
            } else {
                if (mySet.member(x) || otherSet.member(x)) {
                    System.out.println("Nope!!");
                }
            }
        }
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
        // be repeated in concept. 
        // Testing methods by themselves:
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

        // Property testing
        // Will only print error messages. No error messages means that all
        // tests passed successfully.
        addCardP();
        removeCardP();
        addMemberP();
        removeMemberP();
        diffEmptyHuhP();
        isEmptyHuhEmptyP();
        diffMemberP();
        subsetUnionP();
        interUnionEqualP();
        memberUnionP();
    }
}
