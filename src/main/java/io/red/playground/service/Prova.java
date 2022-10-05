package io.red.playground.service;

public class Prova {
    public static void main(String[] args) {
        Boolean[] array = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};

        Positive.countSheeps(array);
    }

    public class Positive {
        public static int countSheeps(Boolean[] arrayOfSheeps) {
            int count = 0;
            for(Boolean arrayOfSheep : arrayOfSheeps) {

            }
            return count;

        }

    }


}
