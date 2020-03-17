package name.ben.shepley.caster;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.to.*;
import name.ben.shepley.caster.to.number.*;
import name.ben.shepley.caster.to.temporal.*;

public final class Caster {
    private final CasterConfiguration casterConfiguration;

    private Caster(CasterConfiguration casterConfiguration) {
        this.casterConfiguration = casterConfiguration;
    }

    public static Caster getInstance() {
        return new Caster(new CasterConfiguration.CasterConfigurationBuilder().build());
    }

    public static Caster getInstance(CasterConfiguration casterConfiguration) {
        return new Caster(casterConfiguration);
    }

    /* String */
    public ToString toStr() {return new ToString(this.casterConfiguration);}

    /* Character */
    public ToCharacter toCharacter() {return new ToCharacter(this.casterConfiguration);}

    /* Boolean */
    public ToBoolean toBoolean() {return new ToBoolean(this.casterConfiguration);}

    /* java.util.Date */
    public ToDate toDate() {return new ToDate(this.casterConfiguration);}

    /* Temporal */
    public ToYear toYear() {return new ToYear(this.casterConfiguration);}
    public ToYearMonth toYearMonth() {return new ToYearMonth(this.casterConfiguration);}
    public ToLocalDate toLocalDate() {return new ToLocalDate(this.casterConfiguration);}
    public ToLocalTime toLocalTime() {return new ToLocalTime(this.casterConfiguration);}
    public ToLocalDateTime toLocalDateTime() { return new ToLocalDateTime(this.casterConfiguration);}

    /* Number */
    public ToBigInteger toBigInteger() {return new ToBigInteger(this.casterConfiguration);}
    public ToBigDecimal toBigDecimal() {return new ToBigDecimal(this.casterConfiguration);}
    public ToLong toLong() {return new ToLong(this.casterConfiguration);}
    public ToInteger toInteger() {return new ToInteger(this.casterConfiguration);}
    public ToShort toShort() {return new ToShort(this.casterConfiguration);}
    public ToByte toByte() {return new ToByte(this.casterConfiguration);}
    public ToDouble toDouble(){return new ToDouble(this.casterConfiguration);}
    public ToFloat toFloat(){return new ToFloat(this.casterConfiguration);}

/*
    Check Castables
    Check names of variables in cast methods
    Check casts
    How are exceptions going to be managed with time / date's?

    String
    Character
    Boolean
    Date
    Temporal
        Year****
        YearMonth****
        LocalDate
        LocalTime
        LocalDateTime
    Number
        BigInteger
        BigDecimal
        Long
        Integer
        Short
        Byte
        Float
        Double
 */


}
