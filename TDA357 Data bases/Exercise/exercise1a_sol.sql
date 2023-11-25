-- The delete everything script to make this file re-runnable
\set QUIET true
SET client_min_messages TO WARNING; -- Less talk please. 
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
\set QUIET false

-- States(_name_, trump, biden, electors)
CREATE TABLE States (
  name TEXT PRIMARY KEY,
  biden INTEGER,
  trump INTEGER,
  electors INTEGER
);

-- Test data
INSERT INTO States VALUES ('NV', 588252,  580605, 6);
INSERT INTO States VALUES ('AZ', 3215969, 3051555, 11);
INSERT INTO States VALUES ('GA', 2406774, 2429783, 16);
INSERT INTO States VALUES ('PA', 3051555, 3215969, 20);
-- Slightly simplified data
INSERT INTO States VALUES ('Red states', 0, 1, 232);
INSERT INTO States VALUES ('Blue states', 1, 0, 253);



-- For the view we started by just selecting the states where biden 
--   is (or rather was at the time) winning, which is the first operand of the
--   union, then we did the same for trump and combined them using union
-- It doesn't really matter if we use UNION or UNION ALL here 
--   since there are no duplicates
CREATE VIEW StateResults AS
(SELECT name, 'Biden' AS candidate, electors 
 FROM States 
 WHERE biden > trump)
UNION ALL 
(SELECT name, 'Trump', electors 
 FROM States 
 WHERE trump > biden);

-- Just checking that it works
SELECT * FROM StateResults;


-- For the final query we group the rows in the view 
--   by the name of candidates, and for each such group 
--   (meaning for each candidate) we compute the sum of electors
-- Using the view makes this a lot easier than working directly with the table!
SELECT candidate, SUM(electors) as total
FROM StateResults
GROUP BY candidate;



