public class NoWhitespacePredicate implements Predicate {
    @Override
    public String hasPredicate(String text) {
        return text.replaceAll("\\s+","");
    }
}
