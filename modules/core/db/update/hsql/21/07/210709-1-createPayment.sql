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
);