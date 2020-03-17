package name.ben.shepley.caster.to.temporal;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.Optional;

public class ToYearMonth extends AbstractTo<ToYearMonth> {
    public ToYearMonth(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Date.class);
        super.castables.add(YearMonth.class);
        super.castables.add(LocalDate.class);
        super.castables.add(LocalDateTime.class);
    }

    @Override
    protected ToYearMonth rtnClass() {
        return this;
    }

    public Optional<YearMonth> cast(String string) {
        return Optional.of(YearMonth.parse(string, super.dateTimeFormatter));
    }

    public Optional<YearMonth> cast(Date date) {
        return Optional.of(YearMonth.of(date.getYear(), date.getMonth()));
    }

    public Optional<YearMonth> cast(Year year) {
        return Optional.of(YearMonth.from(year));
    }

    public Optional<YearMonth> cast(LocalDate localDate) {
        return Optional.of(YearMonth.from(localDate));
    }

    public Optional<YearMonth> cast(LocalDateTime localDateTime) {
        return Optional.of(YearMonth.from(localDateTime));
    }
}
