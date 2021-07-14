alter table SCHEDULEGOODTRY_CLIENT alter column FULL_NAME rename to FULL_NAME__U85800 ^
alter table SCHEDULEGOODTRY_CLIENT alter column FULL_NAME__U85800 set null;
alter table SCHEDULEGOODTRY_CLIENT
    add column PATRONYMIC varchar(255) ^
update SCHEDULEGOODTRY_CLIENT
set PATRONYMIC = ''
where PATRONYMIC is null;
alter table SCHEDULEGOODTRY_CLIENT
    alter column PATRONYMIC set not null;
alter table SCHEDULEGOODTRY_CLIENT
    add column LAST_NAME varchar(255) ^
update SCHEDULEGOODTRY_CLIENT
set LAST_NAME = ''
where LAST_NAME is null;
alter table SCHEDULEGOODTRY_CLIENT
    alter column LAST_NAME set not null;
alter table SCHEDULEGOODTRY_CLIENT
    add column FIRST_NAME varchar(255) ^
update SCHEDULEGOODTRY_CLIENT
set FIRST_NAME = ''
where FIRST_NAME is null;
alter table SCHEDULEGOODTRY_CLIENT
    alter column FIRST_NAME set not null;
