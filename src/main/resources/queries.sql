/*ROLES*/
insert into role ("role_id", "role")
values ( 1, 'ADMIN' );

insert into role ("role_id", "role")
values ( 2, 'USER' );

/*USERS*/
insert into public.user ("user_id", "active", "name", "password")
values ( 1,1,'admin', '$2a$10$6lkQOW3UOuchZvZYjbqLCeVNEtn2Fo2hY7lOwdqVwozC1mtBLxYga' );

insert into public.user ("user_id", "active", "name", "password")
values ( 2,1,'user', '$2a$10$EUqN8N/XiIQl7yOljaEpteUY0I2mmfQaHotl6Y7lcP1.AtxPciy1m' );

/*ADD ROLES TO USERS*/
insert into user_role ("user_id", "role_id") values ( 1,1 ); /*admin*/
insert into user_role ("user_id", "role_id") values ( 1,2 );

insert into user_role ("user_id", "role_id") values ( 2,2 ); /*user*/

INSERT INTO "public"."tags" ("id", "title") VALUES (DEFAULT, 'big');
  
