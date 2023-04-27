package mmgeka.springbeanmanagement.deepdive.messenger.entity;

public record Suffix(String suffix) {
    @Override
    public String toString() {
        return suffix;
    }
}
