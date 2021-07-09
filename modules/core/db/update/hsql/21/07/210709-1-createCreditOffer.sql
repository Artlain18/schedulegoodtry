create table SCHEDULEGOODTRY_CREDIT_OFFER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_ID varchar(36) not null,
    CREDIT_ID varchar(36) not null,
    SUM_CREDIT decimal(19, 2) not null,
    START_DATE timestamp not null,
    PERIOD_CREDIT integer not null,
    --
    primary key (ID)
);