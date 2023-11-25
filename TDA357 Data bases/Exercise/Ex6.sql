-- EX6 

--1a--
 SELECT DISTINCT served
 FROM
 ((SELECT to AS served, airlineName
 FROM Flights JOIN FlightLegs ON FlightLegs.code = Flights.code)
 UNION
 (SELECT from AS served, airlineName
 FROM Flights JOIN FlightLegs ON FlightLegs.code = Flights.code)) AS D
 WHERE D.airlineName = ‘Lufthansa’ OR D.airlineName = ‘SAS’; 

R1 = (PI<to, airlineName>(FlightsLegs JoinOn<code>Flights)) 
R2 = (PI<from, airlineName>(FlightsLegs JoinOn<code>Flights))

RO<D>(<served, airlineName>)(R1 U R2)

PI<served>(DELTA (SIGMA<D.airlineName = 'Lufthansa' OR D.airlineName = 'SAS' >(D)))

--1b--
SELECT First.departureTime, Second.arrivalTime
FROM FlightLegs AS First, FlightLegs AS Second 
WHERE(First.to = Second.from) 

--1c--
PI<code>(
  SIGMA<numFlights > 2>(
      GAMMA<code, Count(*) -> numFlights>(FlightLegs)))

--1d-- (OBS! du vill matcha mot stadsnamn inte mot flygplatskoder)
PI<code>(    
        SIGMA<from = 'Gothenburg' AND to 'London'>( 
          (FlightLegs JoinOn<FlightLegs.code = Airports.code> Airports) 
-- Kass plan för att matcha både avgångar och landningar --> snittet mellan två mängder! 
        )
)

 Froms = π<FlightLegs.code>(σ<city = 'Gothenburg'> (FlightLegs JOINOn< from=Airports.code> Airports)) 
 Tos = π<FlightLegs.code> (σ<city = 'London'> (FlightLegs JOINOn< to=Airports.code> Airports))
R = Froms ∩ Tos 


------------------------2a--------------------------
Answer:  
1. Don''t store the password as a sting!
2. Yes, since a condition that is always true easily can be put 
there the risk of an injectionattack is there (don''t thinkt that the prepared statment alone is enough)

--b)--
Lärdomar: 
1. Commit startar en ny transation. --> därav ropa inte det för varje rad som hanteras, då blir det inga rollback och atomicity 
2. For each loopar termineras inte enbart för att man avänder sig av rollback(). 


















