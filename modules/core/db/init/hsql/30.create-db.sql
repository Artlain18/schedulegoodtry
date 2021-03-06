insert into SCHEDULEGOODTRY_BANK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, BANK_NAME)
values ('e500a022-1ed8-fe30-729c-175d4b6484e8', 1, '2021-07-15 00:31:19', 'admin', '2021-07-15 00:31:19', null, null,
        null, 'Сбербанк') ^

insert into SCHEDULEGOODTRY_CLIENT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LAST_NAME, FIRST_NAME, PATRONYMIC,
 PHONE_NUMBER, EMAIL, PASSPORT_NUMBER, BANK_ID)
values ('cd014edb-a3fd-4306-a1b3-fedf462713ae', 1, '2021-07-15 00:32:39', 'admin', '2021-07-15 00:32:39', null, null,
    null, 'Александров', 'Александр', 'Александрович', '83456534576', 'alex@company.com', '8768789808',
    'e500a022-1ed8-fe30-729c-175d4b6484e8')^

insert into SCHEDULEGOODTRY_CLIENT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LAST_NAME, FIRST_NAME, PATRONYMIC,
 PHONE_NUMBER, EMAIL, PASSPORT_NUMBER, BANK_ID)
values ('f384bf2a-d192-4d50-3908-c233317082af', 1, '2021-07-15 00:33:56', 'admin', '2021-07-15 00:33:56', null, null,
    null, 'Алексеев', 'Алексей', 'Алексеевич', '+74553498572', 'alexey@company.com', '9033845983',
    'e500a022-1ed8-fe30-729c-175d4b6484e8')^

insert into SCHEDULEGOODTRY_CREDIT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME_CREDIT, LIMIT_CREDIT,
 PERCENT_CREDIT, BANK_ID)
values ('ddeebe20-9773-b042-d906-fe6c604d28e9', 1, '2021-07-15 00:35:31', 'admin', '2021-07-15 00:35:31', null, null,
    null, 'Кредит прайм', 50000.00, 22.0, 'e500a022-1ed8-fe30-729c-175d4b6484e8')^

insert into SCHEDULEGOODTRY_CREDIT
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME_CREDIT, LIMIT_CREDIT,
 PERCENT_CREDIT, BANK_ID)
values ('31380a54-565a-b761-58b3-899adfa9a785', 1, '2021-07-15 01:43:37', 'admin', '2021-07-15 01:43:37', null, null,
    null, 'Открытие', 20000.00, 13.0, 'e500a022-1ed8-fe30-729c-175d4b6484e8')^
