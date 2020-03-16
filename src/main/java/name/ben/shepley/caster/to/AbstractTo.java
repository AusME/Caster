package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractTo<T> {
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

    protected abstract T rtnClass();

    public T setRoundingModeEnum(RoundingModeEnum roundingModeEnum) {
        this.roundingModeEnum = roundingModeEnum;
        return this.rtnClass();
    }

    public T setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum) {
        this.exceptionModeEnum = exceptionModeEnum;
        return this.rtnClass();
    }

    public T setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
        return this.rtnClass();
    }

    public T setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
        return this.rtnClass();
    }

    public T setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
        return this.rtnClass();
    }

    public boolean canCast(Class<?> clazz) {
        if (clazz == null) {
            return false;
        } else {
            return this.castables.contains(clazz);
        }
    }
}
