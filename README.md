# Postive Split calculator BE

This application is the backend for calcualating the splits for the type of curve the runner wants to run.

## Installation

1. DB setup.
    1. Install docker
   2. Open terminal
   3. Execute the following in the folder:<br/>[_script/_setupscripts/Environment/development](_script/_setupscripts/Environment/development) <br/>
      Docker will automatically execute the [Dockerfile](_script/_setupscripts/Environment/development/Dockerfile). In the Dockerfile, the [setupscript.sql](_script/_setupscripts/Environment/development/setupscript.sql) will be executed.
   ```bash
      docker build -t db_positive_split_db ./
   ```
   4. Connect to the database with the prefered ide with the following: </br> user : posgtres </br> password : password

## Setup development environment

<p>Because of the use of mapping with Orika, you will need to add the following as Virtual Arguments:</p> 

   ```bash
      --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED
   ```

      

