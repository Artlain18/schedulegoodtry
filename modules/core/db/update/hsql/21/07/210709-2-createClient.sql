alter table SCHEDULEGOODTRY_CLIENT add constraint FK_SCHEDULEGOODTRY_CLIENT_ON_BANK foreign key (BANK_ID) references SCHEDULEGOODTRY_BANK(ID);
create unique index IDX_SCHEDULEGOODTRY_CLIENT_UNIQ_EMAIL on SCHEDULEGOODTRY_CLIENT (EMAIL);
create unique index IDX_SCHEDULEGOODTRY_CLIENT_UNIQ_PASSPORT_NUMBER on SCHEDULEGOODTRY_CLIENT (PASSPORT_NUMBER);
create unique index IDX_SCHEDULEGOODTRY_CLIENT_UNIQ_PHONE_NUMBER on SCHEDULEGOODTRY_CLIENT (PHONE_NUMBER);
create index IDX_SCHEDULEGOODTRY_CLIENT_ON_BANK on SCHEDULEGOODTRY_CLIENT (BANK_ID);
