
:: Create JSON Server
:: JSON Server Need to run before APITest runs.


:: Prerequisites: node installed, check by "node -v"

:: executeCommands:
   call npm install -g json-server
   json-server --watch db.json

:: two options to run this file:
:: 1. double click from its location folder (resource).
:: 2. cmd commands:
::    cd [projectlocationPath]\FinalProject\src\resource 
::    createJSONServer.bat
=
:: not work? open cmd and try to run "executeCommands" commands step by step. 

:: Notes:
:: dont close cmd window - JSON server runs there. 
:: backup file named "dbRecover.json", in case that db.json deleted - copy and rename it.
