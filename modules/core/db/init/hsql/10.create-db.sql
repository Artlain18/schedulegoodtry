-- begin SCHEDULEGOODTRY_PAYMENT
create table SCHEDULEGOODTRY_PAYMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DATE_PAYMENT timestamp not null,
    SUM_PAYMENT decimal(19, 2) not null,
    SUM_CREDIT_PAYMENT decimal(19, 2) not null,
    SUM_PERCENT_PAYMENT decimal(19, 2) not null,
    CREDIT_OFFER_ID varchar(36),
    --
    primary key (ID)
)^
-- end SCHEDULEGOODTRY_PAYMENT
-- begin SCHEDULEGOODTRY_CLIENT
create table SCHEDULEGOODTRY_CLIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FULL_NAME varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    EMAIL varchar(255) not null,
    PASSPORT_NUMBER varchar(255) not null,
    BANK_ID varchar(36),
    --
    primary key (ID)
)^
-- end SCHEDULEGOODTRY_CLIENT
-- begin SCHEDULEGOODTRY_CREDIT
create table SCHEDULEGOODTRY_CREDIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME_CREDIT varchar(255) not null,
    LIMIT_CREDIT decimal(19, 2) not null,
    PERCENT_CREDIT double precision not null,
    BANK_ID varchar(36),
    --
    primary key (ID)
)^
-- end SCHEDULEGOODTRY_CREDIT
-- begin SCHEDULEGOODTRY_BANK
create table SCHEDULEGOODTRY_BANK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SCHEDULEGOODTRY_BANK
-- begin SCHEDULEGOODTRY_CREDIT_OFFER
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
)^
-- end SCHEDULEGOODTRY_CREDIT_OFFER
