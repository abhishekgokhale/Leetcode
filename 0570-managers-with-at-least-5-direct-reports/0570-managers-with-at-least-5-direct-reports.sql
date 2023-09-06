# Write your MySQL query statement below
SELECT name FROM Employee WHERE id IN
(
    SELECT managerId AS counts FROM Employee GROUP BY managerId HAVING count(managerId) >= 5
);