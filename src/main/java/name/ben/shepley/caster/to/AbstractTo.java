package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public interface AbstractTo {
    public abstract AbstractTo setRoundingModeEnum(RoundingModeEnum roundingModeEnum);
    public abstract AbstractTo setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum);
    public abstract AbstractTo setDateTimeFormatter(DateTimeFormatter dateTimeFormatter);
    public abstract AbstractTo setSimpleDateFormat(SimpleDateFormat simpleDateFormat);
    public abstract AbstractTo setDecimalFormat(DecimalFormat decimalFormat);

    public abstract boolean canCast(Class<?> clazz);
}
