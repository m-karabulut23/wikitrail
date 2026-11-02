# WikiTrail

A Java Wikipedia explorer that keeps a readable trail of how you reached each article.

## The Problem

When researching history and politics on Wikipedia, I often follow links to unfamiliar people, events, and places. After several clicks, I lose track of my original topic and why I opened each article. WikiTrail will help me explore related articles while keeping my research path visible.

## MVP Scope (Version 1.0)

WikiTrail is a terminal application that lets a user:

1. Search for a Wikipedia article and read its introduction.
2. Select a related hyperlink to explore another article.
3. View the complete ordered research trail and return to an earlier article.

The core goal is to make a multi-article Wikipedia research session navigable without losing its starting context. The graphical map and saved notes are **not** MVP requirements.

## How It Works

The Java terminal interface accepts searches and link selections. The application fetches data from Wikipedia's public API, parses the returned JSON, displays an article summary and available links, and updates an in-memory history of visited articles. The user can show the trail or return to a previous article.

See [System Diagram](docs/system-diagram.mmd) and [Eisenhower Matrix](docs/eisenhower-matrix.md).

## Tech Stack

- **Language:** Java 17+
- **Interface:** Terminal input and output (`Scanner`)
- **HTTP:** Built-in `java.net.http.HttpClient`
- **JSON:** Gson
- **Data structures:** `ArrayList` for the trail, `HashMap` for cached articles
- **External data:** Public [Wikipedia MediaWiki API](https://www.mediawiki.org/wiki/API:Main_page), accessed with HTTP GET requests, returning JSON
- **Storage:** In-memory data for V1.0; local JSON session files planned for a later version

## Setup

1. Install JDK 17 or newer and Maven.
2. Clone this repository once it is published and enter its folder.
3. Add the Maven project configuration and Java source during the first build milestones.
4. Compile and run according to the instructions added alongside the implementation.

**Status:** Planning stage. The application is not implemented yet, so there is currently no working run command.

## Usage (Planned)

```text
Search Wikipedia: Mustafa Kemal Atatürk
1. Mustafa Kemal Atatürk - article introduction...
Related links: [1] Ottoman Empire [2] Young Turks ...
Choose link, trail, back, or quit: 1
Trail: Mustafa Kemal Atatürk -> Ottoman Empire
```

## Roadmap (Version 2.0+)

- [ ] Add a Java Swing GUI and interactive visual article map.
- [ ] Attach notes to individual articles and save sessions to JSON.
- [ ] Generate contextual explanations of links to the original topic.
- [ ] Produce structured summaries and recommend related articles.

## Milestones

See [Chunked Build Plan](docs/build-plan.md). Each milestone is intended as one meaningful Git commit.

## Author

Mehmet Karabulut
