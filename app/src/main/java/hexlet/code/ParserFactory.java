package hexlet.code;

/**
 * ParserFactory.
 */
public class ParserFactory {

    /**
     * getParser.
     * @param dataType String
     * @return parcer
     * @throws RuntimeException Exception
     */
    public final Parser getParser(final String dataType)
            throws RuntimeException {
        return switch (dataType) {
            case "json" -> new hexlet.code.parsers.JsonParser();
            case "yml" -> new hexlet.code.parsers.YmlParser();
            default -> throw new RuntimeException("There is no suitable parser "
                    + "for provided data type: " + dataType);
        };
    }
}


