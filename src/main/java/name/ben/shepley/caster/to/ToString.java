package name.ben.shepley.caster.to;

import name.ben.shepley.caster.configuration.CasterConfiguration;

import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Optional;

public final class ToString extends AbstractTo<ToString> {
    public ToString(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(char.class);
        super.castables.add(Character.class);
        super.castables.add(boolean.class);
        super.castables.add(Boolean.class);
        super.castables.add(byte[].class);
        super.castables.add(Date.class);
        super.castables.add(Temporal.class);
        super.castables.add(Number.class);
    }

    @Override
    protected ToString rtnClass() {
        return this;
    }

    public Optional<String> cast(char character) {
        return Optional.of(String.valueOf(character));
    }

    public Optional<String> cast(boolean bool) {
        return Optional.of(String.valueOf(bool));
    }

    public Optional<String> cast(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return Optional.empty();
        } else {
            return Optional.of(new String(bytes));
        }
    }

    public Optional<String> cast(Date date) {
        if (date == null) {
            return Optional.empty();
        } else {
            return Optional.of(super.simpleDateFormat.format(date));
        }
    }

    public Optional<String> cast(Temporal temporal) {
        if (temporal == null) {
            return Optional.empty();
        } else {
            return Optional.of(super.dateTimeFormatter.format(temporal));
        }
    }

    public Optional<String> cast(Number number) {
        if (number == null) {
            return Optional.empty();
        } else {
            return Optional.of(super.decimalFormat.format(number));
        }
    }
}
