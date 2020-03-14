package name.ben.shepley.caster;

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

    public final static class CasterConfiguration {
        public enum RoundingModeEnum {
            ROUND_UP,
            ROUND_DOWN,
            ONLY_EQUAL;
        }

        public enum ExceptionModeEnum {
            THROW,
            DONT_THROW;
        }

        public final RoundingModeEnum roundingModeEnum;
        public final ExceptionModeEnum exceptionModeEnum;
        public final DateTimeFormatter dateTimeFormatter;
        public final SimpleDateFormat simpleDateFormat;
        public final DecimalFormat decimalFormat;

        private CasterConfiguration(CasterBuilder casterBuilder) {
            this.roundingModeEnum = casterBuilder.roundingModeEnum;
            this.exceptionModeEnum = casterBuilder.exceptionModeEnum;
            this.dateTimeFormatter = casterBuilder.dateTimeFormatter;
            this.simpleDateFormat = casterBuilder.simpleDateFormat;
            this.decimalFormat = casterBuilder.decimalFormat;
        }
    }

    public final static class CasterBuilder {
        private CasterConfiguration.RoundingModeEnum roundingModeEnum = CasterConfiguration.RoundingModeEnum.ROUND_UP;
        private CasterConfiguration.ExceptionModeEnum exceptionModeEnum = CasterConfiguration.ExceptionModeEnum.DONT_THROW;
        private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");;
        private DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");;

        public Caster build() {
            return new Caster(new CasterConfiguration(this));
        }

        public CasterBuilder setRoundingModeEnum(CasterConfiguration.RoundingModeEnum roundingModeEnum) {
            this.roundingModeEnum = roundingModeEnum;
            return this;
        }

        public CasterBuilder setExceptionModeEnum(CasterConfiguration.ExceptionModeEnum exceptionModeEnum) {
            this.exceptionModeEnum = exceptionModeEnum;
            return this;
        }

        public CasterBuilder setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
            return this;
        }

        public CasterBuilder setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
            this.simpleDateFormat = simpleDateFormat;
            return this;
        }

        public CasterBuilder setDecimalFormat(DecimalFormat decimalFormat) {
            this.decimalFormat = decimalFormat;
            return this;
        }
    }
}
