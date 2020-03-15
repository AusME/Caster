package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractTo {
    protected RoundingModeEnum roundingModeEnum;
    protected ExceptionModeEnum exceptionModeEnum;
    protected DateTimeFormatter dateTimeFormatter;
    protected SimpleDateFormat simpleDateFormat;
    protected DecimalFormat decimalFormat;

    protected List<Class<?>> castables = new LinkedList<>();

    protected AbstractTo(CasterConfiguration casterConfiguration) {
        this.roundingModeEnum = casterConfiguration.getRoundingModeEnum();
        this.exceptionModeEnum = casterConfiguration.getExceptionModeEnum();
        this.dateTimeFormatter = casterConfiguration.getDateTimeFormatter();
        this.simpleDateFormat = casterConfiguration.getSimpleDateFormat();
        this.decimalFormat = casterConfiguration.getDecimalFormat();
    }

    public abstract AbstractTo setRoundingModeEnum(RoundingModeEnum roundingModeEnum);
    public abstract AbstractTo setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum);
    public abstract AbstractTo setDateTimeFormatter(DateTimeFormatter dateTimeFormatter);
    public abstract AbstractTo setSimpleDateFormat(SimpleDateFormat simpleDateFormat);
    public abstract AbstractTo setDecimalFormat(DecimalFormat decimalFormat);

    public boolean canCast(Class<?> clazz) {
        return castables.contains(clazz);
    }
}
