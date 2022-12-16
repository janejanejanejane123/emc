begin;
select *
from ums_member
where id = 1 for update;
rollback;
批量插入几千条数据，慎用foreach

