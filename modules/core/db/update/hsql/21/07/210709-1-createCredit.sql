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
);