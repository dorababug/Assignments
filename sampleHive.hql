--create table txt(line string);


select word,count(word) as cnt from
(select 
	explode(split(line," ")) word 
from txt 
) A group by A.word;
