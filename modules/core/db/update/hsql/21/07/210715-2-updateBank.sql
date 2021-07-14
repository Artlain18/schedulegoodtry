alter table SCHEDULEGOODTRY_BANK alter column NAME rename to NAME__U52148 ^
alter table SCHEDULEGOODTRY_BANK alter column NAME__U52148 set null;
-- alter table SCHEDULEGOODTRY_BANK add column BANK_NAME varchar(255) ^
-- update SCHEDULEGOODTRY_BANK set BANK_NAME = <default_value> ;
-- alter table SCHEDULEGOODTRY_BANK alter column BANK_NAME set not null ;
alter table SCHEDULEGOODTRY_BANK
    add column BANK_NAME varchar(255);
