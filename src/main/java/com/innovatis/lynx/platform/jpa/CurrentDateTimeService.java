package com.innovatis.lynx.platform.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;

/**
 * Created by Ramakrishna Chalasani 02/01/2017.
 */
public class CurrentDateTimeService implements DateTimeService {

    private static final Logger logger = LoggerFactory.getLogger(CurrentDateTimeService.class);

    @Override
    public ZonedDateTime getCurrentDateTime() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        logger.info("Returning current data time: {}", currentDateTime);

        return currentDateTime;
    }
}
