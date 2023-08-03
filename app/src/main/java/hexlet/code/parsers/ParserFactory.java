package hexlet.code.parsers;

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
    public static final Parser getParser(final String dataType)
            throws RuntimeException {
        return switch (dataType) {
            case "json" -> new JsonParser();
            case "yml" -> new YmlParser();
            default -> throw new RuntimeException("There is no suitable parser "
                    + "for provided data type: " + dataType);
        };
    }
}


