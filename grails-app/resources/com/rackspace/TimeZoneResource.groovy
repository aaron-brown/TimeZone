package com.rackspace

// Imports
import javax.ws.rs.Path
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.Get

import static org.grails.jaxrs.response.Responses.*

@consumes(['text/plain'])
@produces(['text/plain'])

@Path('/api/tz')

class TimeZoneResource
{
    @GET
    @PATH('/')
    Response returnCurrentTime(@QueryParam('timezone') String timezone)
    {
        def result = TimeZoneService.getTime(timezone)
        
        ok result
    }
