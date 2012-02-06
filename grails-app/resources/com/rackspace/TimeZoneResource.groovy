package com.rackspace

// Imports
import javax.ws.rs.Path
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.GET

import javax.ws.rs.core.Response

import static org.grails.jaxrs.response.Responses.*

@Consumes(['text/plain'])
@Produces(['text/plain'])

@Path('/api')

class TimeZoneResource
{
    def TimeZoneResource
    
    @GET
    @Path('/')
    Response returnCurrentTime(@QueryParam('timezone') String timezone)
    {
        def result = TimeZoneService.getTime(timezone).toString()
        
        ok result
    }
}