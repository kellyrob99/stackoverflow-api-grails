/*
 * Copyright (c) 2010.
 */


package org.kar

/**
 * @author Kelly Robinson
 */
class StackOverflowAPIConstants
{
    /** all of the available root domains       **/
    static def DOMAINS = [
            'stackoverflow.com',
            'serverfault.com',
            'superuser.com',
            'meta.stackoverflow.com',
            'stackapps.com']

    static def VERSION = '0.8'

    /** all of the api endpoints        **/
    static def API = ["/answers/{id}": "Gets a set of questions enumerated in id.",
            "/answers/{id}/comments": "Gets the comments associated with a set of answers.",
            "/badges": "Gets all badges, in alphabetical order.",
            "/badges/{id}": "Gets the users that have been awarded the badges identified in 'id'.",
            "/badges/name": "Gets all standard, non-tag-based badges in alphabetical order.",
            "/badges/tags": "Gets all tag-based badges in alphabetical order.",
            "/comments/{id}": "Gets comments by ids.",
            "/errors/{id}": "Simulates an error given a code",
            "/posts/{id}/comments": "Gets the comments associated with a set of posts (questions and/or answers).",
            "/questions": "Gets question summary information.",
            "/questions/{id}": "Gets the set questions identified in 'id' and their answers.",
            "/questions/{id}/answers": "Gets any answers to the question in 'id'.",
            "/questions/{id}/comments": "Gets the comments associated with a set of questions.",
            "/questions/{id}/timeline": "Gets the timeline of events for the questions in 'id'.",
            "/questions/tagged/{tags}": "Gets questions that are tagged with 'tags'.",
            "/questions/unanswered": "Gets questions that have no upvoted answers.",
            "/revisions/{id}": "Gets the post history revisions for a set of posts in 'id'.",
            "/revisions/{id}/{revisionguid}": "Get a specific post revision.",
            "/search": "Searches questions. One of tagged, nottagged, or intitle must be set. Searches that are purely text based should be routed through a third-party search engine, for performance reasons.",
            "/stats": "Gets various system statistics.",
            "/tags": "Gets the tags on all questions, along with their usage counts.",
            "/users": "Gets user summary information.",
            "/users/{id}": "Gets summary information for a set of users.",
            "/users/{id}/answers": "Gets answer summary information for a set of users.",
            "/users/{id}/badges": "Gets the badges that have been awarded to a set of users.",
            "/users/{id}/comments": "Gets the comments that a set of users have made.",
            "/users/{id}/comments/{toid}": "Gets the comments by a set of users that mention the user with 'toid'.",
            "/users/{id}/favorites": "Gets summary information for the questions that have been favorited a set of users.",
            "/users/{id}/mentioned": "Gets comments that are directed at a set of users.",
            "/users/{id}/questions": "Gets question summary information for a set of users.",
            "/users/{id}/reputation": "Gets information on reputation changes for a set of users.",
            "/users/{id}/tags": "Gets the tags that a set of users has participated in.",
            "/users/{id}/timeline": "Gets actions a set of users have performed."
    ]
}
