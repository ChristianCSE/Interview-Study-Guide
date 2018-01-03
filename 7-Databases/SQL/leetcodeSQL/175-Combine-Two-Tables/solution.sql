--Person
-- +-------------+---------+
-- | Column Name | Type |
-- +-------------+---------+
-- | PersonId    | int     |
-- | FirstName   | varchar |
-- | LastName    | varchar |
-- +-------------+---------+
--

--Address
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | AddressId   | int     |
-- | PersonId    | int     |
-- | City        | varchar |
-- | State       | varchar |
-- +-------------+---------+




-- Write your MySQL query statement below
select p.FirstName, p.LastName, a.City, a.State
from Person p
left join Address a on a.PersonId = p.PersonId