package name.ben.shepley.caster.configuration;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public final class CasterConfiguration {
    private final RoundingModeEnum roundingModeEnum;
    private final ExceptionModeEnum exceptionModeEnum;
    private final DateTimeFormatter dateTimeFormatter;
    private final SimpleDateFormat simpleDateFormat;
    private final DecimalFormat decimalFormat;

    public CasterConfiguration(RoundingModeEnum roundingModeEnum, ExceptionModeEnum exceptionModeEnum, DateTimeFormatter dateTimeFormatter, SimpleDateFormat simpleDateFormat, DecimalFormat decimalFormat) {
        this.roundingModeEnum = roundingModeEnum;
        this.exceptionModeEnum = exceptionModeEnum;
        this.dateTimeFormatter = dateTimeFormatter;
        this.simpleDateFormat = simpleDateFormat;
        this.decimalFormat = decimalFormat;
    }

    public RoundingModeEnum getRoundingModeEnum() {
        return roundingModeEnum;
    }

    public ExceptionModeEnum getExceptionModeEnum() {
        return exceptionModeEnum;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public final static class CasterConfigurationBuilder {
        private RoundingModeEnum roundingModeEnum = RoundingModeEnum.ROUND_DOWN;
        private ExceptionModeEnum exceptionModeEnum = ExceptionModeEnum.DONT_THROW;
        private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        private DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");

        public CasterConfiguration build() {
            return new CasterConfiguration(roundingModeEnum, exceptionModeEnum, dateTimeFormatter, simpleDateFormat, decimalFormat);
        }

        public RoundingModeEnum getRoundingModeEnum() {
            return roundingModeEnum;
        }
        public CasterConfigurationBuilder setRoundingModeEnum(RoundingModeEnum roundingModeEnum) {
            this.roundingModeEnum = roundingModeEnum;
            return this;
        }

        public ExceptionModeEnum getExceptionModeEnum() {
            return exceptionModeEnum;
        }
        public CasterConfigurationBuilder setExceptionModeEnum(ExceptionModeEnum exceptionModeEnum) {
            this.exceptionModeEnum = exceptionModeEnum;
            return this;
        }

        public DateTimeFormatter getDateTimeFormatter() {
            return dateTimeFormatter;
        }
        public CasterConfigurationBuilder setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
            return this;
        }

        public SimpleDateFormat getSimpleDateFormat() {
            return simpleDateFormat;
        }
        public CasterConfigurationBuilder setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
            this.simpleDateFormat = simpleDateFormat;
            return this;
        }

        public DecimalFormat getDecimalFormat() {
            return decimalFormat;
        }
        public CasterConfigurationBuilder setDecimalFormat(DecimalFormat decimalFormat) {
            this.decimalFormat = decimalFormat;
            return this;
        }
    }
}
