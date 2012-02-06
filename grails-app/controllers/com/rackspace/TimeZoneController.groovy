package com.rackspace

class TimeZoneController
{
    def api =
    {
        def timezoneService = new TimeZoneService()        
        def result = timezoneService.getTime(params["timezone"] ?: "America/Central")
        render result
    }
}
