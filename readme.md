# F-SQL
I believe existing ORM's fulfill the axiom of design by contract well, but in so doing become the intersection of all the weakest features of all DBMSs.

Because of that, I am designing F-Sql to be type safe, fail fast, and allow the developer to access specific queryResultsFactory implementation features.

### Description
F-SQL primarily consists of THREE parts:
1. Query: Stores SQL, and parameters. This is designed around specific DBMS implementations to support specific DBMS features.
2. QueryStream: Stores the resulting information from the query execution.
   - QueryCollector: Generic collector to collect queryResultsFactory results into models or primitives.
3. Database: A Singleton Factory which exxecutes queries and returns QueryStreams.

### Examples
COMING SOON.