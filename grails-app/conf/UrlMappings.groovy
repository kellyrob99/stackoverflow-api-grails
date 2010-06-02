/*
 * Copyright (c) 2010.
 */

class UrlMappings
{
    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }
        "/"(view: "/index")
        "500"(view: '/error')
    }
}
