# telus-online-voting-site

Developer test with the aim of evaluate knowledge and technical skills in web development areas


## Requirements

- NodeJS v6.8.1 or later
- npm v3.10.0 or later
- Bower 1.7.9 or later
- JDK 8
- IntelliJ IDEA v14.x or later
- Scala plugin for IntelliJ IDEA
- MySQL server

## Getting started

- Clone this repo

`$ git clone git@github.com:jonathanpalma/telus-online-voting-site.git`


- Move to the root of the project and install bower dependencies

`$ cd telus-online-voting-site`

`$ bower i`


- Open project from IntelliJ 

![Open project](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/open-project.png)


- Check "Download sources for SBT and plugins" and hit Ok!

![Conf project](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/conf-project.png)


- Wait while SBT downloads all the dependencies

![Downloading dependencies](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/download-dependencies.png)


- Create an empty database named `telus-voting` (Is not necessary to import the script because when the project start it will check the schemma version and ask you for run migrations)

![Empty db](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/empty-db.png)


- Add a play server

![Edit conf](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/edit-conf.png)

![Add conf](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/add-conf.png)

![Play conf](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/play-conf.png)


- Hit the play icon next to `telus` Play 2 App

![Play app](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/play-start.png)


- It will check the database schemma and will ask you for migrations

![Migrate](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/db-migrate.png)


- And there you go :smile:

## Deliverables

- Entity Relationship diagram.
![Database diagram](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/db-diagram.png)

- [Database Scripts](https://github.com/jonathanpalma/telus-online-voting-site/tree/master/project/conf/db/migration/default).


- [Web Voting application](https://github.com/jonathanpalma/telus-online-voting-site/tree/master/project).

![Voting demo](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/voting-demo.png)


... but the best part is that statistics are reactive :raised_hands::fire:

![Demo](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/demo.gif)

- [Web service to provide information to external resources](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/project/app/controllers/web/Api.java).

![WS demo](https://github.com/jonathanpalma/telus-online-voting-site/blob/master/README/ws-demo.png)
