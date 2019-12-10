public enum Color {

    B,

    W,

    EMPTY;

    public Color flip() {
        switch(this) {
            case B:
                return W;
            case W:
                return B;
            default:
                return EMPTY;
        }
    }
}
