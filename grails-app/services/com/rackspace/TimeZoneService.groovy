package com.rackspace

import java.text.SimpleDateFormat
import java.text.Format

class TimeZoneService
{

    static transactional = true

    def getTime(def timezone)
    {
        def format = new SimpleDateFormat()
        format.setTimeZone(TimeZone.getTimeZone(timezone))
        return format.format(new Date())
    }
}
