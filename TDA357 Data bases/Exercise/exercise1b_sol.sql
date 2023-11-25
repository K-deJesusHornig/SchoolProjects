
\set QUIET true
SET client_min_messages TO WARNING; -- Less talk please. 
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
\set QUIET false

-- Players(_name_, level, money)
--   money >= 0
CREATE TABLE Players (
  name TEXT PRIMARY KEY,
  level INTEGER NOT NULL,
  money INTEGER NOT NULL,
  CHECK (money >= 0)
  );


-- Items(_id_, itemname, value)
--   value >= 0
CREATE TABLE Items(
  id INTEGER PRIMARY KEY, 
  itemname TEXT NOT NULL, 
  value INTEGER NOT NULL,
  CHECK (value >= 0));


-- Equippable(_id_, equipslot)
--  id -> Items.id
CREATE TABLE Equippable(
  id INTEGER PRIMARY KEY, 
  equipslot TEXT NOT NULL, 
  FOREIGN KEY (id) REFERENCES Items, -- Same as Items(id)
  -- This is just required to be able to refer to both id and equipslot
  --   it has no effect on what you can add to this table since id is already PK
  UNIQUE (id, equipslot) 
  );

-- PlayerInventory(_player_, _item_)
--   item -> Items.id
--   player -> Players.name
CREATE TABLE PlayerInventory(
  player TEXT,
  item INTEGER, 
  PRIMARY KEY (item, player),
  FOREIGN KEY (item) REFERENCES Items,
  FOREIGN KEY (player) REFERENCES Players
  );


-- Equipped(_player_, item, _equipslot_)
--   (item, equipslot) -> Equippable(id, equipslot)
--   player -> Players.name
CREATE TABLE Equipped (
  player TEXT, 
  item INTEGER, 
  equipslot TEXT,
  PRIMARY KEY (player, equipslot),
  FOREIGN KEY (item, equipslot) REFERENCES Equippable(id, equipslot),
  FOREIGN KEY (player) REFERENCES Players
  );

-- Inserts
INSERT INTO Items VALUES (0, 'Java Direkt med Swing', 542);
INSERT INTO Items VALUES (1, 'Databases: The complete book', 495);
INSERT INTO Items VALUES (2, 'Vorpal sword', 10000);
INSERT INTO Items VALUES (3, 'Oven mitts +1', 999);

INSERT INTO Equippable VALUES (1, 'weapon');
INSERT INTO Equippable VALUES (2, 'weapon');
INSERT INTO Equippable VALUES (3, 'hands');

INSERT INTO Players VALUES ('jonas', 80, 50000);
INSERT INTO Players VALUES ('Leeroy Jenkins', 14, 0);

INSERT INTO PlayerInventory VALUES ('jonas', 			1);
INSERT INTO PlayerInventory VALUES ('jonas', 			3);
INSERT INTO PlayerInventory VALUES ('Leeroy Jenkins', 	1);

INSERT INTO Equipped VALUES ('jonas', 			2, 'weapon');
INSERT INTO Equipped VALUES ('Leeroy Jenkins', 	3, 'hands');


-- Failing inserts

-- INSERT INTO Equipped VALUES ('jonas', 0, 'hands');
-- INSERT INTO Equipped VALUES ('jonas', 1, 'hands');
-- INSERT INTO Equipped VALUES ('jonas', 1, 'weapon');
-- INSERT INTO Players VALUES ('jonas', 0, 0);

-- Query 1
SELECT itemname 
  FROM PlayerInventory, Items
  WHERE item = id AND player = 'jonas';


-- 2
SELECT AVG(value) AS average_value FROM Items;

-- 3
SELECT id, COUNT(player) AS owners 
  FROM Items LEFT OUTER JOIN PlayerInventory ON item = id
  GROUP BY id;

-- 4
WITH Weapons AS ( -- Create a "helper table" with all equipped weapons
  SELECT player, itemname 
    FROM Equipped, Items 
	WHERE item = id AND equipslot = 'weapon'
  )
SELECT name, COALESCE(itemname, 'Nothing') -- Add players with no weapons
  FROM Players LEFT OUTER JOIN Weapons ON player = name 
  ;
  
-- 5
SELECT itemname
  FROM Items, Equipped, Players
  WHERE id = item AND name = player AND level > 75 AND value > 500;
  
-- 6
WITH Everything AS (
   SELECT item, player FROM PlayerInventory
   UNION ALL
   SELECT item, player FROM Equipped
   )
SELECT player, SUM(value) AS total
  FROM Everything, Items
  WHERE id=item
  GROUP BY player;

-- 7
-- This is for testing that the query works
-- INSERT INTO Equipped VALUES ('Leeroy Jenkins', 	1, 'weapon');
SELECT * 
  FROM PlayerInventory, Equippable 
  WHERE item = id AND player = 'Leeroy Jenkins'
                  AND equipslot NOT IN 
                      (SELECT equipSlot FROM Equipped WHERE player = 'Leeroy Jenkins') 
                  ;

