package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ToCharacter implements AbstractTo {
    private List<Class<?>> castables = new LinkedList<>();

    private RoundingModeEnum roundingModeEnum;
    private ExceptionModeEnum exceptionModeEnum;
    private DateTimeFormatter dateTimeFormatter;
    private SimpleDateFormat simpleDateFormat;
    private DecimalFormat decimalFormat;

    public ToCharacter(CasterConfiguration casterConfiguration) {
        this.roundingModeEnum = casterConfiguration.getRoundingModeEnum();
        this.exceptionModeEnum = casterConfiguration.getExceptionModeEnum();
        this.dateTimeFormatter = casterConfiguration.getDateTimeFormatter();
        this.simpleDateFormat = casterConfiguration.getSimpleDateFormat();
        this.decimalFormat = casterConfiguration.getDecimalFormat();

        this.castables.add(String.class);
    }

    @Override
    public ToCharacter setRoundingModeEnum(RoundingModeEnum roundingModeEnum) {
        this.roundingModeEnum = roundingModeEnum;
        return this;
    }

    @Override
    public ToCharacter setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum) {
        this.exceptionModeEnum = exceptionModeEnum;
        return this;
    }

    @Override
    public ToCharacter setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
        return this;
    }

    @Override
    public ToCharacter setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        return this;
    }

    @Override
    public ToCharacter setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
        return this;
    }

    @Override
    public boolean canCast(Class<?> clazz) {
        return this.castables.contains(clazz);
    }

    /*   String,
     *   char Character,
     *   boolean Boolean,
     *   byte[],
     *   java.util.Date
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Number: (BigInteger, BigDecimal, Long, Integer, Short, Byte, Double, Float),
     */

    public Optional<Character> cast(String string) {
        if (string == null || string.length() == 0) {
            return Optional.empty();
        } else {
            switch (roundingModeEnum) {
                case ROUND_UP:
                    return Optional.of(string.charAt(string.length() - 1));
                case ROUND_DOWN:
                    return Optional.of(string.charAt(0));
                case ONLY_EQUAL:
                    if (string.length() == 1) {
                        return Optional.of(string.charAt(0));
                    } else {
                        return Optional.empty();
                    }
                default:
                    return Optional.empty();
            }
        }
    }

    public Optional<Character> cast(boolean bool) {
        return Optional.of((bool)? 'T' : 'F');
    }

    public Optional<Number> cast(Number number) {
        return Optional.empty();
    }


}
