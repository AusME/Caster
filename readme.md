# Caster
Caster is a thread safe general purpose, intended to be intuitive, Java framework for casting primitives into other primitives in a pain-free way. Caster can be built to custom configuration, then put into a Spring Context or used as a static variable safely.

### Examples
/* Default Configuration (Use CasterConfigurationBuilder to customize) */
RoundingModeEnum roundingModeEnum = RoundingModeEnum.ROUND_DOWN;
ExceptionModeEnum exceptionModeEnum = ExceptionModeEnum.DONT_THROW;
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
DecimalFormat decimalFormat = new DecimalFormat("#,###,##0.000");

/* Uses default configuration (above) */
Caster caster = Caster.newInstance();

/* Casts "6" and stores result into i */
int i = caster.toInteger().cast("6").get();

/* b is false, since optional is empty */
boolean b = caster.toInteger().cast("A").isPresent();

/* setExceptionModeEnum overrides default configuration, thus, cast() throws Exception */
int i = caster.toInteger().setExceptionMo Q deEnum(ExceptionModeEnum.THROW).cast("A").get();

/* b is false since default configuration says, don't throw and it can't cast, thus empty is returned. */
boolean b = caster.toInteger().cast("A").isPresent();
