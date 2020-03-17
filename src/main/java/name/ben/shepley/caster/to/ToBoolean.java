package name.ben.shepley.caster.to;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.util.Optional;

public class ToBoolean extends AbstractTo<ToBoolean> {

    public ToBoolean(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Boolean.class);
        super.castables.add(boolean.class);
        super.castables.add(Number.class);
    }

    @Override
    protected ToBoolean rtnClass() {
        return this;
    }

    public Optional<Boolean> cast(String string) {
        if (string == null || string.isBlank()) {
            return Optional.empty();
        } else {
            if (string.equals("T")  || string.equals("Y")) {
                return Optional.of(Boolean.TRUE);
            } else if (string.equals("F")  || string.equals("N")) {
                return Optional.of(Boolean.TRUE);
            } else {
                return Optional.empty();
            }
        }
    }

    public Optional<Boolean> cast(Character character) {
        if (character == null || character == '\0') {
            return Optional.empty();
        } else {
            if (character.equals('T')  || character.equals('Y')) {
                return Optional.of(Boolean.TRUE);
            } else if (character.equals('F')  || character.equals('N')) {
                return Optional.of(Boolean.TRUE);
            } else {
                return Optional.empty();
            }
        }
    }

    public Optional<Boolean> cast(Number number) {
        if (number == null) {
            return Optional.empty();
        } else {
            long num = number.longValue();
            if (num == 0L) {
                return Optional.of(Boolean.FALSE);
            } else if (num == 1L) {
                return Optional.of(Boolean.TRUE);
            } else {
                if (super.roundingModeEnum.equals(RoundingModeEnum.ONLY_EQUAL)) {
                    if (super.exceptionModeEnum.equals(ExceptionModeEnum.THROW)) {
                        throw new ArithmeticException("Attempted to cast a non-zero number where Rounding Mode was set to ONLY_EQUAL");
                    } else {
                        return Optional.empty();
                    }
                } else {
                    if (num >= 1L) {
                        return Optional.of(Boolean.TRUE);
                    } else {
                        return Optional.of(Boolean.FALSE);
                    }
                }
            }
        }
    }


}
