package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;

public final class ToString extends AbstractTo {
    /*   String,
     *   char Character,
     *   boolean Boolean,
     *   byte[],
     *   java.util.Date
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Number: (BigInteger, BigDecimal, Long, Integer, Short, Byte, Double, Float),
     */

    public ToString(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(char.class);
        super.castables.add(Character.class);
        super.castables.add(boolean.class);
        super.castables.add(Boolean.class);
        super.castables.add(byte[].class);
        super.castables.add(Date.class);
        super.castables.add(Temporal.class);
        super.castables.add(Number.class);
    }

    @Override
    public ToString setRoundingModeEnum(RoundingModeEnum roundingModeEnum) {
        super.roundingModeEnum = roundingModeEnum;
        return this;
    }

    public Optional<String> cast(char character) {
        return Optional.of(String.valueOf(character));
    }

    public Optional<String> cast(boolean bool) {
        return Optional.of(String.valueOf(bool));
    }

    public Optional<String> cast(byte[] bytes) {
        return Optional.of(new String(bytes));
    }

    public Optional<String> cast(Date date) {
        return Optional.of(super.simpleDateFormat.format(date));
    }

    public Optional<String> cast(Temporal temporal) {
        return Optional.of(super.dateTimeFormatter.format(temporal));
    }

    public Optional<String> cast(Number number) {
        return Optional.of(super.decimalFormat.format(number));
    }

}
