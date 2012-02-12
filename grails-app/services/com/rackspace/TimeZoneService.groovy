package com.rackspace

import java.util.Collections

import java.text.SimpleDateFormat
import java.text.Format

class TimeZoneService {
    static transactional = false

    private List<String> validTimeZoneNames = Arrays.asList(TimeZone.getDefault().getAvailableIDs()).sort()

    def getTime(def timezone) {
        def toTimeZone = Calendar.getInstance(TimeZone.getTimeZone(timezone))
        toTimeZone.setTimeInMillis(new Date().getTime())

        def result = [
                         "TimeZone"      : toTimeZone.getTimeZone().getDisplayName(Locale.US),
                         "Year"          : toTimeZone.get(Calendar.YEAR),
                         "Month"         : toTimeZone.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US),
                         "Day"           : toTimeZone.get(Calendar.DAY_OF_MONTH),
                         "Hour"          : toTimeZone.get(Calendar.HOUR_OF_DAY),
                         "Minute"        : toTimeZone.get(Calendar.MINUTE),
                         "Second"        : toTimeZone.get(Calendar.SECOND),
                         "Millisecond"   : toTimeZone.get(Calendar.MILLISECOND)
                     ]

        return [result]
    }

    def getTimeZoneList() {
        def tzList = [:]
        def i = 0;
        def key = "timezone"
        for (name in validTimeZoneNames.toArray()) {
            tzList[key.concat(i.toString())] = name
            i++
        }
        
        return [tzList]
    }

    def validateParam(String queryParam) {
        def result = [[]]
        def test = Collections.binarySearch(validTimeZoneNames, queryParam)

        if (test > 0) {
           result = [
                        "errorFlag"    : "ok",
                        "suggestions"  : null
                    ]   
           
            return [result]
        }
        else {
            def variants = [:]
            def i = 0
            def key = "suggestion"
            for(name in validTimeZoneNames) {
                if(name.contains(queryParam) == true) {
                    variants[key.concat(i.toString())] = name
                    i++
                }
            }

            result = [
                         "errorFlag"    : "Invalid Name Format",
                         "suggestions"  : variants
                     ]
            
            return [result]
        }
    }
}
