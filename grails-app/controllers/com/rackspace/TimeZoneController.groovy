package com.rackspace

class TimeZoneController
{
    def api =
    {
        def timezoneService = new TimeZoneService()        
        def result = timezoneService.getTime(params["timezone"] ?: "US/Central")
        render result
    }
}
