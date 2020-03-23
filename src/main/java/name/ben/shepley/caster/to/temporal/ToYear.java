package name.ben.shepley.caster.to.temporal;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.Optional;

public class ToYear extends AbstractTo<ToYear> {
    public ToYear(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Date.class);
        super.castables.add(YearMonth.class);
        super.castables.add(LocalDate.class);
        super.castables.add(LocalDateTime.class);
    }

    @Override
    protected ToYear parent() {
        return this;
    }

    public Optional<Year> cast(String string) {
        return Optional.of(Year.parse(string, super.dateTimeFormatter));
    }

    public Optional<Year> cast(Date date) {
        return Optional.of(Year.of(date.getYear()));
    }

    public Optional<Year> cast(YearMonth yearMonth) {
        return Optional.of(Year.from(yearMonth));
    }

    public Optional<Year> cast(LocalDate localDate) {
        return Optional.of(Year.from(localDate));
    }

    public Optional<Year> cast(LocalDateTime localDateTime) {
        return Optional.of(Year.from(localDateTime));
    }
}
