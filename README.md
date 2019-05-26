# Overview
Spring-Boot application interacts with h2 database via JPA-Hibernate.
Controller provides 2 mappings:
1) `/postdir?dirpath=<path-to-directory>` - post mapping, 
saves the directory information to database and returns it. If there is no such directory, it simply returns 404 error code.
2) `/dirs` - get mapping, returns all directories from the database

# How to run
Git, JDK and Gradle are required to be installed. Run the following commands in the terminal:

`git clone git@github.com:andreimironov/iactestback.git`

`cd iactestback`

`gradle bootRun`
