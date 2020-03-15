package name.ben.shepley.caster.configuration;

import name.ben.shepley.caster.Caster;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public final class CasterConfiguration {

    private final RoundingModeEnum roundingModeEnum;
    private final ExceptionModeEnum exceptionModeEnum;
    private final DateTimeFormatter dateTimeFormatter;
    private final SimpleDateFormat simpleDateFormat;
    private final DecimalFormat decimalFormat;

    public CasterConfiguration(RoundingModeEnum roundingModeEnum, ExceptionModeEnum exceptionModeEnum, DateTimeFormatter dateTimeFormatter, SimpleDateFormat simpleDateFormat, DecimalFormat decimalFormat) {
        this.roundingModeEnum = roundingModeEnum;
        this.exceptionModeEnum = exceptionModeEnum;
        this.dateTimeFormatter = dateTimeFormatter;
        this.simpleDateFormat = simpleDateFormat;
        this.decimalFormat = decimalFormat;
    }

    public CasterConfiguration(Caster.CasterBuilder casterBuilder) {
        this.roundingModeEnum = casterBuilder.getRoundingModeEnum();
        this.exceptionModeEnum = casterBuilder.getExceptionModeEnum();
        this.dateTimeFormatter = casterBuilder.getDateTimeFormatter();
        this.simpleDateFormat = casterBuilder.getSimpleDateFormat();
        this.decimalFormat = casterBuilder.getDecimalFormat();
    }

    public RoundingModeEnum getRoundingModeEnum() {
        return roundingModeEnum;
    }

    public ExceptionModeEnum getExceptionModeEnum() {
        return exceptionModeEnum;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }
}