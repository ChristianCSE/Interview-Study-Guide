--Task: List everyone in a group in a single row
select e.name, array_agg(person.fName), array_agg(person.lName), array_agg(person.pid)
from group e
inner join atLoc on atLoc.locId = e.locId
inner join person on (atLoc.pid = person.pid and person.region = e.region)
group by e.name