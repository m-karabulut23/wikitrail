
# WikiTrail

A Java Wikipedia explorer that helps users research interconnected topics without losing track of their original research path.

## The Problem

When researching history and politics on Wikipedia, I often follow hyperlinks to unfamiliar people, events, and places. After opening several related articles, I lose track of my original topic and how the information connects.

WikiTrail aims to solve this problem by keeping a record of visited articles and allowing users to navigate their research history.

## MVP Scope (Version 1.0)

WikiTrail will be a Java terminal application with three core features:

1. **Wikipedia Search:** Search for a Wikipedia article and retrieve its introduction.
2. **Hyperlink Navigation:** Display related articles and allow users to select which ones to explore.
3. **Research History:** Track visited articles and allow users to return to previously explored topics.

The MVP focuses on providing a complete and reliable research experience without requiring a graphical interface.

## How It Works

1. The user enters a Wikipedia search query.
2. The application sends an HTTP GET request to Wikipedia's API.
3. The API returns article information in JSON format.
4. Gson parses the JSON response to extract titles, summaries, and related links.
5. The application displays the article and a numbered list of related topics.
6. The user selects another article to explore.
7. The program records each visited article in an ArrayList.
8. The user can view their research history and return to earlier articles.

### System Diagram

[View System Diagram (PDF)](cs193diagram.drawio.pdf)

### Eisenhower Matrix

[View Eisenhower Matrix (PDF)](eisenhower-matrix.pdf)

### Chunked Build Plan

[View Build Plan](docs/build-plan.md)

## Tech Stack

- **Language:** Java 17+
- **Interface:** Command-line interface (CLI)
- **HTTP Requests:** Java HttpClient (`java.net.http`)
- **JSON Parsing:** Gson
- **User Input:** Java Scanner
- **Data Structures:** ArrayList and HashMap
- **External API:** Wikipedia MediaWiki API
- **Data Format:** JSON
- **Storage:** In-memory research history for Version 1.0

## Project Structure

```text
wikitrail/
├── README.md
├── cs193diagram.drawio.pdf
├── eisenhower-matrix.pdf
├── docs/
│   ├── build-plan.md
│   └── eisenhower-matrix.md
└── src/
    ├── main/
    │   └── java/
    └── test/
        └── java/
```

## Setup

### Requirements

- Java Development Kit (JDK) 17 or newer
- Apache Maven
- Internet connection

### Installation

Clone the repository:

```bash
git clone https://github.com/m-karabulut23/wikitrail.git
```

Navigate into the project:

```bash
cd wikitrail
```

**Development Status:** WikiTrail is currently in the planning stage. Compilation and execution instructions will be added as the Java application is implemented.

## Usage (Planned)

Example interaction:

```text
Welcome to WikiTrail!

Search Wikipedia: Mustafa Kemal Atatürk

Article: Mustafa Kemal Atatürk
Summary: Mustafa Kemal Atatürk was the founder
and first president of the Republic of Turkey.

Related Articles:
1. Ottoman Empire
2. Turkish War of Independence
3. Republic of Turkey

Enter an article number: 2

Article: Turkish War of Independence

Research History:
Mustafa Kemal Atatürk -> Turkish War of Independence

Options:
1. Explore related articles
2. View research history
3. Return to previous article
4. Exit
```

## Future Plans (Version 2.0+)

After completing the MVP, I plan to implement:

- [ ] **Interactive Knowledge Graph:** Use Java Swing and Graphics2D to visually display relationships between articles.
- [ ] **Research Notes:** Allow users to attach notes to articles.
- [ ] **Session Storage:** Save and load research sessions using JSON files.
- [ ] **AI Contextual Explanations:** Explain how each article relates to the original research topic.
- [ ] **Automatic Summaries:** Generate organized summaries of research sessions.
- [ ] **Article Recommendations:** Suggest relevant topics based on the user's research.

## Development Milestones

The project will be implemented through nine milestones, with each milestone corresponding to a meaningful Git commit.

See the [Chunked Build Plan](docs/build-plan.md) for details.

## Author

**Mehmet Karabulut**

GitHub: [m-karabulut23](https://github.com/m-karabulut23)
