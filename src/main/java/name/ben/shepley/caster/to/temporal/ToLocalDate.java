package name.ben.shepley.caster.to.temporal;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.*;
import java.util.Date;
import java.util.Optional;

public class ToLocalDate extends AbstractTo<ToLocalDate> {
    public ToLocalDate(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Date.class);
        super.castables.add(Year.class);
        super.castables.add(YearMonth.class);
        super.castables.add(LocalDateTime.class);
    }

    @Override
    protected ToLocalDate parent() {
        return this;
    }

    public Optional<LocalDate> cast(String string) {
        return Optional.of(LocalDate.parse(string, super.dateTimeFormatter));
    }

    public Optional<LocalDate> cast(Date date) {
        return Optional.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public Optional<LocalDate> cast(Year year) {
        return Optional.of(LocalDate.from(year));
    }

    public Optional<LocalDate> cast(YearMonth yearMonth) {
        return Optional.of(LocalDate.from(yearMonth));
    }

    public Optional<LocalDate> cast(LocalDateTime localDateTime) {
        return Optional.of(LocalDate.from(localDateTime));
    }
}