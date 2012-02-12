package com.rackspace

// Imports
import javax.ws.rs.Path
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.GET

import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.*

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])

@Path('/api')

class TimeZoneResource
{
    def TimeZoneService
    
    @GET
    @Path('/time')
    Response getTime(@QueryParam('timezone') String timezone)
    {
        def testValid = TimeZoneService.validateParam(timezone ?: 'US/Central')
        def result
        
        if (testValid[0].getAt("errorFlag").equals("ok")) {
            result = TimeZoneService.getTime(timezone ?: 'US/Central')
        }
        else {
            result = testValid
        }
        ok result
    }
    
    @GET
    @Path('/timezonelist')
    Response getTimeZoneList()
    {
        def result = TimeZoneService.getTimeZoneList()
        
        ok result
    }
}