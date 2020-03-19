package name.ben.shepley.caster.to;

import name.ben.shepley.caster.AbstractTo;
import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;

import java.util.Optional;

public final class ToCharacter extends AbstractTo<ToCharacter> {
    public ToCharacter(CasterConfiguration casterConfiguration) {
        super(casterConfiguration);

        super.castables.add(String.class);
        super.castables.add(Boolean.class);
        super.castables.add(boolean.class);
        super.castables.add(Number.class);
    }

    @Override
    protected ToCharacter rtnClass() {
        return this;
    }

    public Optional<Character> cast(String string) {
        if (string == null || string.isBlank()) {
            return Optional.empty();
        } else {
            switch (roundingModeEnum) {
                case ROUND_UP:
                    return Optional.of(string.charAt(string.length() - 1));
                case ROUND_DOWN:
                    return Optional.of(string.charAt(0));
                case ONLY_EQUAL:
                    if (string.length() == 1) {
                        return Optional.of(string.charAt(0));
                    } else {
                        return Optional.empty();
                    }
                default:
                    return Optional.empty();
            }
        }
    }

    public Optional<Character> cast(boolean bool) {
        return Optional.of((bool)? 'T' : 'F');
    }

    public Optional<Character> cast(Number number) {
        if (number.longValue() > Character.MAX_VALUE) {
            if (super.roundingModeEnum.equals(RoundingModeEnum.ONLY_EQUAL)) {
                if (super.exceptionModeEnum.equals(ExceptionModeEnum.THROW)) {
                    throw new ArithmeticException("Attempted to cast a Number into a Character where the Number is larger than the Character's ability to store. ");
                } else {
                    return Optional.empty();
                }
            } else {
                return Optional.of(Character.MAX_VALUE);
            }
        } else if (number.longValue() < Character.MIN_VALUE) {
            if (super.roundingModeEnum.equals(RoundingModeEnum.ONLY_EQUAL)) {
                if (super.exceptionModeEnum.equals(ExceptionModeEnum.THROW)) {
                    throw new ArithmeticException("Attempted to cast a Number into a Character where the Number is smaller than the Character's ability to store. ");
                } else {
                    return Optional.empty();
                }
            } else {
                return Optional.of(Character.MIN_VALUE);
            }
        } else {
            return Optional.of((char) number.longValue());
        }
    }
}
