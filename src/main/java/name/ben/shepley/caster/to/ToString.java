package name.ben.shepley.caster.to;

import name.ben.shepley.caster.Caster;

import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;

public final class ToString {
    private final Caster.CasterConfiguration casterConfiguration;
    public ToString(Caster.CasterConfiguration casterConfiguration) {
        this.casterConfiguration = casterConfiguration;
    }

    /*   String,
     *   char Character,
     *   boolean Boolean,
     *   byte[],
     *   java.util.Date
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Number: (BigInteger, BigDecimal, Long, Integer, Short, Byte, Double, Float),
     */

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
        return Optional.of(this.casterConfiguration.simpleDateFormat.format(date));
    }

    public Optional<String> cast(Temporal temporal) {
        return Optional.of(this.casterConfiguration.dateTimeFormatter.format(temporal));
    }

    public Optional<String> cast(Number number) {
        return Optional.of(this.casterConfiguration.decimalFormat.format(number));
    }

}
