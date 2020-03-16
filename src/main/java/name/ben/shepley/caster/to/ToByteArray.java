package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;

public class ToByteArray extends AbstractTo<ToByteArray> {

    public ToByteArray(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        this.castables.add(String.class);
        this.castables.add(Boolean.class);
        this.castables.add(boolean.class);
        this.castables.add(Number.class);
    }

    @Override
    protected ToByteArray rtnClass() {
        return this;
    }

    /*   String,
     *   char Character,
     *   boolean Boolean,
     *   byte[],
     *   java.util.Date
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Number: (BigInteger, BigDecimal, Long, Integer, Short, Byte, Double, Float),
     */


}
