package com.rackspace

import java.text.SimpleDateFormat
import java.text.Format

class TimeZoneService
{

    static transactional = false

    def getTime(def timezone)
    {
        def toTimeZone = Calendar.getInstance(TimeZone.getTimeZone(timezone))
        toTimeZone.setTimeInMillis(new Date().getTime())
        
        def result = [
                        [
                            "Year"          : toTimeZone.get(Calendar.YEAR),
                            "Month"         : toTimeZone.get(Calendar.MONTH),
                            "Day"           : toTimeZone.get(Calendar.DAY_OF_MONTH),
                            "Hour"          : toTimeZone.get(Calendar.HOUR_OF_DAY),
                            "Minute"        : toTimeZone.get(Calendar.MINUTE),
                            "Second"        : toTimeZone.get(Calendar.SECOND),
                            "Millisecond"   : toTimeZone.get(Calendar.MILLISECOND)
                        ]
                     ]
        
        return result
    }
}
