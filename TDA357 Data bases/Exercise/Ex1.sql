## EXCERCISE 1 

## 1A 
##  Make a table with a column for state names (or abbreviations), columns for Biden and Trump votes respectively and a column for number of electors. 

CREATE TABLE States (
name TEXT, 
biden INTEGER NOT NULL,
trump INTEGER NOT NULL,
electors INTEGER NOT NULL,
PRIMARY KEY (name)
); 

## PLUS ALLA INSERTS

##Then create a view called StateResults that shows for each state: The name of the state, the name of the winning candidate (Biden or Trump) and the number of electors.


CREATE VIEW StateResults AS
(SELECT name AS State, 'Biden' AS candidate , electors 
FROM States 
WHERE biden > trump)
UNION
(SELECT name AS State, 'Trump' AS candidate , electors 
FROM States 
WHERE biden < trump)
; 

## SE den med 
SELECT * FROM StateResults; 

## Notera hur vi skapar två individuella views för att sedan merge:a
## UNION ALL could also be used since no duplicates in our data. 


## Finally make a query that shows the total number of electoral votes of both candidates (the result should have two rows for the two candidates).

## Första tankar: att vi inte har värdet än, vi behöver beräkan det --> summerar med aggregationsfunktion! 

SELECT candidate, SUM(electors) 
FROM StateResults
GROUP BY candidate;

## Notera hur man inte kan köra "select *" 
(går inte att efterfråga alla värden när det är en group by)
och man kan heller inte köra "select candidate, electors" 
(då denna inte definierar vilket värde för groupen som ska väljas) 



## 1B

## SCHEMAS + TRANSLATION

## Players(_name_, level, money)
	money >= 0 

CREATE TABLE Players( 
name TEXT PRIMARY KEY, 
level INTEGER NOT NULL, 
money INTEGER NOT NULL,
CHECK (money >=0)
);

## Items(_id_, itemname, value)

CREATE TABLE Items (
id INTEGER PRIMARY KEY, 
itemname TEXT NOT NULL, 
value INTEGER NOT NULL,
CHECK (value >= 0) 
);

##Equippable(_id_, equipslot)
	id --> items.id 

CREATE TABLE Equippable (
id INTEGER PRIMARY KEY, 
equipslot TEXT NOT NULL, 
FOREIGN KEY (id) REFERENCES Items(id),
UNIQUE (id,equipslot)
);

##PlayerInventory(_player_, _item_)
	player --> players.name
	item --> items.id

CREATE TABLE PlayerInventory(   ##ERROR, don't know why though
player TEXT,
item INTEGER NOT NULL,
PRIMARY KEY(player,item), 
FOREIGN KEY (player) REFERENCES Players(name)
FOREIGN KEY (item) REFERENCES Items(id)
);

##Equipped(_player_, item, _equipslot_)
	Player --> players.name
	item --> items.id  							##denna impliceras av den nedan
	(item, equipslot) --> equipable(id, equipslot) 

CREATE TABLE Equipped(  ##ERROR, don't know why though
player TEXT,
item INTEGER NOT NULL,
equipslot TEXT NOT NULL,
PRIMARY KEY(player,equipslot), 
FOREIGN KEY (player) REFERENCES Players(name)
FOREIGN KEY (item, equipslot) REFERENCES Equippable(id,equipslot)
);











