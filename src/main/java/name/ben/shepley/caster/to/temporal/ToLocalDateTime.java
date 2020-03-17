package name.ben.shepley.caster.to.temporal;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.*;
import java.util.Date;
import java.util.Optional;

public class ToLocalDateTime extends AbstractTo<ToLocalDateTime> {
    public ToLocalDateTime(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Date.class);
        super.castables.add(YearMonth.class);
        super.castables.add(LocalDate.class);
        super.castables.add(LocalDateTime.class);
    }

    @Override
    protected ToLocalDateTime rtnClass() {
        return this;
    }

    public Optional<LocalDateTime> cast(String string) {
        return Optional.of(LocalDateTime.parse(string, super.dateTimeFormatter));
    }

    public Optional<LocalDateTime> cast(Date date) {
        return Optional.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public Optional<LocalDateTime> cast(long instant) {
        return Optional.of(Instant.ofEpochMilli(instant).atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    public Optional<LocalDateTime> cast(Year year) {
        return Optional.of(LocalDateTime.from(year));
    }

    public Optional<LocalDateTime> cast(YearMonth yearMonth) {
        return Optional.of(LocalDateTime.from(yearMonth));
    }

    public Optional<LocalDateTime> cast(LocalDate localDate) {
        return Optional.of(LocalDateTime.from(localDate));
    }

}