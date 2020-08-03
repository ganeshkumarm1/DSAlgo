package Algorithms.MOAlgorithm.DistinctVowels;

class Query1 implements Comparable<Query1> {
    int index;
    int l;
    int r;

    public Query1(int index, int l, int r) {
        this.index = index;
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Query1 query) {
        int l = this.l / DistinctVowels.BLOCK_SIZE;
        int r = query.l / DistinctVowels.BLOCK_SIZE;
        if (l != r) {
            return l - r;
        } else {
            return this.r - query.r;
        }
    }
}