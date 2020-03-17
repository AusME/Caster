package name.ben.shepley.caster.to;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;

import java.text.ParseException;
import java.time.*;
import java.util.Date;
import java.util.Optional;

public class ToDate extends AbstractTo<ToDate> {
    public ToDate(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Year.class);
        super.castables.add(YearMonth.class);
        super.castables.add(LocalDate.class);
        super.castables.add(LocalDateTime.class);
        super.castables.add(Long.class);
        super.castables.add(long.class);
    }

    @Override
    protected ToDate rtnClass() {
        return this;
    }

    public Optional<Date> cast(String date) {
        try {
            return Optional.of(super.simpleDateFormat.parse(date));
        } catch (ParseException e) {
           if (super.exceptionModeEnum.equals(ExceptionModeEnum.THROW)) {
               throw new RuntimeException(e);
           } else {
               return Optional.empty();
           }
        }
    }

    public Optional<Date> cast(Year year) {
        return Optional.of(Date.from(year.atMonth(1).atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    public Optional<Date> cast(YearMonth yearMonth) {
        return Optional.of(Date.from(yearMonth.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    public Optional<Date> cast(LocalDate localDate) {
        return Optional.of(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }


    public Optional<Date> cast(LocalDateTime localDateTime) {
        return Optional.of(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public Optional<Date> cast(long date) {
        return Optional.of(new Date(date));
    }
}
