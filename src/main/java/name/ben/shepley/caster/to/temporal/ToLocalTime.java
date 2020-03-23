package name.ben.shepley.caster.to.temporal;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class ToLocalTime extends AbstractTo<ToLocalTime> {
    public ToLocalTime(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Date.class);
        super.castables.add(long.class);
        super.castables.add(Long.class);
    }

    @Override
    protected ToLocalTime parent() {
        return this;
    }

    public Optional<LocalTime> cast(String string) {
        return Optional.of(LocalTime.parse(string, super.dateTimeFormatter));
    }

    public Optional<LocalTime> cast(Date date) {
        return Optional.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
    }

    public Optional<LocalTime> cast(long instant) {
        return Optional.of(Instant.ofEpochMilli(instant).atZone(ZoneId.systemDefault()).toLocalTime());
    }
}
