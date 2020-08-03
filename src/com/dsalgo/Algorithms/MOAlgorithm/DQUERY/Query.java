package Algorithms.MOAlgorithm.DQUERY;

class Query implements Comparable<Query> {
    int index;
    int l;
    int r;

    public Query(int index, int l, int r) {
        this.index = index;
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Query query) {
        int l = this.l / DQUERY.BLOCK_SIZE;
        int r = query.l / DQUERY.BLOCK_SIZE;
        if (l != r) {
            return l - r;
        } else {
            return this.r - query.r;
        }
    }
}