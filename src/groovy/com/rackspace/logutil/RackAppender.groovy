package com.rackspace.logutil

import org.apache.log4j.AppenderSkeleton
import org.apache.log4j.spi.LoggingEvent
import org.apache.log4j.spi.ErrorCode
import org.apache.log4j.Layout
import org.apache.log4j.helpers.LogLog

import com.rackspace.logutil.LogDB

class RackAppender extends AppenderSkeleton
{ 
    @Override
    public void close()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean requiresLayout()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void append(LoggingEvent event)
    {
        LogDB entry = new LogDB(timestamp:   new Date().toString(),
                                packageName: event.getLoggerName(),
                                className:   s[s.length-1],
                                level:       event.getLevel().toString(),
                                message:     event.getMessage().toString()
                               )
        
        entry.save(flush:true, failOnError:true)
        
        /*
        println "Class: " + s[s.length-1]
        println "Level: " + event.getLevel()
        println "Logger name: " + event.getLoggerName()
        /*
        println "Message: " + event.getMessage()
        println "NDC: " + event.getNDC()
        println "Properties: " + event.getProperties()
        println "Rendered Message: " + event.getRenderedMessage()
        println "Timestamp: " + new Date(event.getTimeStamp()).toString()
        */
    }
}
