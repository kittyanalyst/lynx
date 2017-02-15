package com.innovatis.lynx.platform.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Ramakrishna Chalasani 02/01/2017.
 */
public class ConstantDateTimeService implements DateTimeService {

    private static final Logger logger = LoggerFactory.getLogger(ConstantDateTimeService.class);

    public static final String CURRENT_DATE_TIME = getConstantDateTime();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    private static String getConstantDateTime() {
        return String.format("2016-05-20T12:00:00%s", getSystemZoneOffset());
    }

    private static String getSystemZoneOffset() {
        return ZonedDateTime.now().getOffset().toString();
    }

    @Override
    public ZonedDateTime getCurrentDateTime() {
        ZonedDateTime constantDateTime = ZonedDateTime.from(FORMATTER.parse(CURRENT_DATE_TIME));

        logger.info("Returning constant date and time: {}", constantDateTime);

        return constantDateTime;
    }


}
