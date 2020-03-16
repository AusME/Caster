package name.ben.shepley.caster;

import name.ben.shepley.caster.configuration.CasterConfiguration;
import name.ben.shepley.caster.configuration.ExceptionModeEnum;
import name.ben.shepley.caster.configuration.RoundingModeEnum;
import name.ben.shepley.caster.to.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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

    /* byte[] */
    public ToByteArray toByteArray() {return new ToByteArray(this.casterConfiguration);}

    /* java.util.date */
    public ToDate toDate() {return new ToDate(this.casterConfiguration);}

    /* Temporal */
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


}
