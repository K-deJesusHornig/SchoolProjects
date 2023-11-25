3.1 a) 
R (a,b,c,d,e)
Keys: (a,c,e), (b,c,e), (c,e,d)

Lösning: leta efter de du inte kan derivera fram, c och e här, 
sen varierar du den sista platserna för att få hela R

b)
{b, c}+ = b,c,d
{a, c}+ = a,b,c,d
{b, d, e}+ = a,b,d,e

c) 
Räcker med att den bryter mot en
för hand...

d) se 
för hand...

3.2 (HAR INTE FÅTT DENNA RÄTTAD, MED SER BRA UT...)

R(A,B,C,D,E)
A -> B 
C -> D 
E -> A

e.g.
Lectures(courseCode, courseTitle, date, room, compemdium)

Assume: 
- each compemdium can only have one course, since its very specific for that course. 
- each lecture can have mutiple teacher.
- that the course has at most one lecture each date
- each course can have mutiple compendiums. (else we get A->E) 
/*
THE LEASSON TO LEARN: the sets A, B, E and C,D can be completly separated and 
then we can focus on the easier task which is to only satisfy  E -> A, A -> B 
*/ 


3.3 
WATING UNTIL AFTER OLD EXAMS. 

-- Extra övningarna i gamla tentor: 2019-06-10, question 2, 
A) 
-Update anomaly e.g. when changing the name of Hermione in one of 
the two places it occurs. 
/*
Generell lösning: uppdatera en rad name, dessa förekommer på flera rader och ska 
eftersom det syftar på samma sak uppdatera alla men lyckas inte.  */

-Deletion anomaly e.g. if deleting all grades issued for course TDA357 
and losing the information on the number of credits the course has.
/*
Generell lösning: wanting to delete all info for one column-values matching 
certain values in another column --> plus by accident deleting data not intended 
in a third column, which just so happens to be in these rows too. 
    Probelmatiken: att det finns flera columner som håller info för samma sak 
    men ibland avses inte samtliga av dessa*/

B)  
studentID -> studentName
CourseID -> credits
studentID, CourseID -> grade 

C) på tavlan... 
Students(_student_id_, student_name) ‐‐ 4 rows
Courses(_course_id_, credits) ‐‐ 3 rows 
Grades(_student_id_, _course_id_, grade) ‐‐ 6 rows

Glöm inte att schman också har primary keys! 


-- 2019-08-29, question 2
a) 
{E}+ = (a,b,e)
{B, C}+ = (a,b,c,e)
{C, D}+ = (c,d)

B) 
Minimal keys: (a,c,d), (b,c,d), (c,d,e) 

OBS ALPHABETICAL ORDER!! 

C) 
Cannot find the combination from the key (facit) 
But the auto-tool gives the same as my calc.


