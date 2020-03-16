package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class ToString implements AbstractTo {
    private List<Class<?>> castables = new LinkedList<>();

    private RoundingModeEnum roundingModeEnum;
    private ExceptionModeEnum exceptionModeEnum;
    private DateTimeFormatter dateTimeFormatter;
    private SimpleDateFormat simpleDateFormat;
    private DecimalFormat decimalFormat;

    public ToString(CasterConfiguration casterConfiguration) {
        this.roundingModeEnum = casterConfiguration.getRoundingModeEnum();
        this.exceptionModeEnum = casterConfiguration.getExceptionModeEnum();
        this.dateTimeFormatter = casterConfiguration.getDateTimeFormatter();
        this.simpleDateFormat = casterConfiguration.getSimpleDateFormat();
        this.decimalFormat = casterConfiguration.getDecimalFormat();

        this.castables.add(char.class);
        this.castables.add(Character.class);
        this.castables.add(boolean.class);
        this.castables.add(Boolean.class);
        this.castables.add(byte[].class);
        this.castables.add(Date.class);
        this.castables.add(Temporal.class);
        this.castables.add(Number.class);
    }

    @Override
    public ToString setRoundingModeEnum(RoundingModeEnum roundingModeEnum) {
        this.roundingModeEnum = roundingModeEnum;
        return this;
    }

    @Override
    public ToString setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum) {
        this.exceptionModeEnum = exceptionModeEnum;
        return this;
    }

    @Override
    public ToString setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
        return this;
    }

    @Override
    public ToString setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        return this;
    }

    @Override
    public ToString setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
        return this;
    }

    @Override
    public boolean canCast(Class<?> clazz) {
        if (clazz == null) {
            return false;
        } else {
            return this.castables.contains(clazz);
        }
    }

    public Optional<String> cast(char character) {
        return Optional.of(String.valueOf(character));
    }

    public Optional<String> cast(boolean bool) {
        return Optional.of(String.valueOf(bool));
    }

    public Optional<String> cast(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return Optional.empty();
        } else {
            return Optional.of(new String(bytes));
        }
    }

    public Optional<String> cast(Date date) {
        if (date == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.simpleDateFormat.format(date));
        }
    }

    public Optional<String> cast(Temporal temporal) {
        if (temporal == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.dateTimeFormatter.format(temporal));
        }
    }

    public Optional<String> cast(Number number) {
        if (number == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.decimalFormat.format(number));
        }
    }

}
