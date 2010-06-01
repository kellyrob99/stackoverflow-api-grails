package stackoverflow.plugin

import groovyx.net.http.HTTPBuilder
import org.kar.StackOverflowAPIConstants
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.Method.GET

class StackAppsController
{

    def index = { }

    def show = {
        def action = params.find {it.key == ('_action_show')}
        def (domain, method) = action.value.split('_')
        def ident = params.ident
        def index = StackOverflowAPIConstants.api.keySet().findIndexOf {it == method.toString()}
        def id = ident[index]
        if (method.contains('{id}'))
        {
            if (id)
            {
                method = method.toString().replace('{id}', id)
            }
            else
            {
                return [answer: "ID is required for the $method method."]
            }
        }

        println domain
        println method
        def http = new HTTPBuilder("http://api.$domain")
        def answer
        http.request(GET, JSON) {
            uri.path = "/0.8$method"
//            if (id)
//            {
//                uri.query = [id: id]
//            }
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code:
            response.success = { resp, json ->
                answer = json
            }

            // handler for any failure status code:
            response.failure = { resp ->
                answer = "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }
        [answer: answer]
    }

}
