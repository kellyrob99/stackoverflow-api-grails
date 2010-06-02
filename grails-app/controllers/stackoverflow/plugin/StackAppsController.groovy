/*
 * Copyright (c) 2010.
 */





package stackoverflow.plugin

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.GET
import static org.kar.StackOverflowAPIConstants.*

/**
 * @author Kelly Robinson
 */
class StackAppsController
{

    def index = { }

    def show = {
        def action = params.find {it.key == ('_action_show')}
        def (domain, method) = action.value.split('_')
        def ident = params.ident
        if (method.contains('{id}'))
        {
            def index = API.keySet().findIndexOf {it == method.toString()}
            def id = ident[index]
            if (id)
            {
                method = method.toString().replace('{id}', id)
            }
            else
            {
                return [answer: "ID is required for the $method method."]
            }
        }

        def answer
        def http = new HTTPBuilder("http://api.$domain")
        http.request(GET, JSON) {
            uri.path = "/${VERSION}$method"
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            response.success = { resp, json ->
                answer = json
            }

            response.failure = { resp ->
                answer = "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }
        [answer: answer, domain: domain, method: method]
    }

}
