# Contributing

Mbed Cloud SDK for Java is an open source project from Arm Mbed.

We really appreciate your contributions! You can contribute by letting us know
about any [SDK issues](https://github.com/ARMmbed/mbed-cloud-sdk-java/issues)
you have found, or by creating a [pull request](https://github.com/ARMmbed/mbed-cloud-sdk-java/pulls)
with a bug fix or new feature you find necessary, important or just attractive.

## How to Contribute Code

Please keep contributions small and independent. We would much rather have
multiple pull requests for each cool thing you've done rather than have them all
in the same one. This will help us review, give feedback and merge in your
changes.

- Fork the repository.
- Generate the project files for your IDE of choice (Eclipse or IntelliJ) using gradle: `./gradlew eclipse` or `./gradlew idea` and import the project to your IDE.
- Make your change and write unit tests, please do match the existing coding
  style. _Code style checks and static analysis are performed during build._
  If using Eclipse as an IDE, there is a `preferences` file for development in /config/eclipse. Ensure code styling is performed on [`save`](http://www.eclipseonetips.com/2009/12/13/automatically-format-and-cleanup-code-every-time-you-save/).
- Write a [good commit message](http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html)
  and be sure to mention the issue if contributing a bug fix.
- Write a news fragment for any non-trivial changes as a new file in `docs/news`  e.g. `123.feature`. (see [towncrier](https://github.com/hawkowl/towncrier#news-fragments) for more fragment types).
- Push to your fork.
- Submit a pull request.

We will review your proposal, give you feedback and merge your changes if we
feel your contribution is generally useful and meets our quality criteria.

## Merging the Pull Request

When merging the pull request we will give it a title which provides context to changes:
* `:<emoji>: <Issue-Number> <Change Summary> (#<Pull Request Number>)`

An emoji will be used to highlight what has occurred in the change:

Emoji | GitHub Markdown | Topic(s)
------|-----------------|---------
🏁 | `:checkered_flag:` | New release
🎁 | `:gift:` | Features / New good stuff
🔧 | `:wrench:` | Bug / Defect fixes
❌ | `:x:` | Removing features / Deprecation
🔒 | `:lock:` | Security
🚀 | `:rocket:` | Performance
💰 | `:moneybag:` | Technical debt
📖 | `:book:` | Documentation
🔃 | `:arrows_clockwise:` | Synchronising (normally between branches)
⭕️ | `:o:` | CircleCI / Build system

Additional emojis which are more likely to be used in commits than in a merge:

Emoji | GitHub Markdown | Topic(s)
------|-----------------|---------
🌈 | `:rainbow:` | Linting and appearance fixes
📰 | `:newspaper:` | Newsfile (news snippet)
🚧 | `:construction:` | Work In Progress (WIP)
⬆️ | `:arrow_up:` |️ Upgrade dependency
⬇️ | `:arrow_down:` | Downgrade dependency

## One Last Thing...

For us to accept your code contributions, we will need you to agree to our [Mbed
Contributor Agreement](http://developer.mbed.org/contributor_agreement/) to give
us the necessary rights to use and distribute your contributions.

Thank you!
