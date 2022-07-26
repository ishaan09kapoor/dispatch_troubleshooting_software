INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_DESCRIPTION","ERROR_TITLE","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02","STEP03","STEP04","STEP05","STEP06","STEP07","STEP08","STEP09","STEP10")
VALUES(101,'Client can not connect to server. Reasons why: 1) Dispatch server is disconnected or offline, 2) a Dispatch service on the server is not running, 3) a network or firewall issue is causing client to not connect to server','Error: Connecting to Server',False,1,'Corbin King',101,102,103,104,null,null,null,null,null,null) ;
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_DESCRIPTION","ERROR_TITLE","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02","STEP03")
VALUES(102,'Dispatch server problem, or all shovels have been disabled in LP','Error: Multiple No LP Solution',False,1,'Corbin King',102,103,104);
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_DESCRIPTION","ERROR_TITLE","IS_TYPE_OTHER","SEVERITY","SPOC")
VALUES(99,'Other','Other',True,1,'Corbin King');
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_DESCRIPTION","ERROR_TITLE","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02")
VALUES(103,'Mine network (Rajant) issue; or firewall rule issue.','Error: Multiple Can not Talk Messages',False,1,'Corbin King',105,106);
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_TITLE","ERROR_DESCRIPTION","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02", "STEP03", "STEP04")
VALUES(104,'Dispatch is running slow','Dispatch is sensitive to network lag. Occasionally there may be a service/task that is consuming significant computing resource.',False,2,'Corbin King',107,108, 101, 104);
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_TITLE","ERROR_DESCRIPTION","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02", "STEP03")
VALUES(105,'Dispatch forms are slow','Likely network lag. Anything over 20 ms ping time causes noticeable performance issues. Above 50 ms forms become unusable.',False,2,'Corbin King',107,101, 104);
INSERT INTO ERROR_METADATA_ENTITY  ("ERROR_CODE","ERROR_TITLE","ERROR_DESCRIPTION","IS_TYPE_OTHER","SEVERITY","SPOC","STEP01","STEP02")
VALUES(106,'Can not run Intellimine reports','Occasional timeout issue with reporting server; or SQL server is having issues.',False,2,'Corbin King',109,110);




insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(101, true, 'function1',1,'Try opening Dispatch on jump server', 'firewall testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(102, true, 'function1',1,'Try fetching data from the dispatch SQL DB', 'db connectivity testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(103, true, 'function1',1,'ping mordsapp server', 'sever resource availability testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(104, false, 'function1',1,'priority call to modular', 'modular issue', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(105, false, 'function1',1,'have dispatcher call on-call radio shop number 928-215-2115 to check on Rajant network health', 'rajant testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(106, false, 'function1',1,'place high-priority ticket with MIS help desk to check network or firewall', 'firewall testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(107, false, 'function1',1,'wait for 5-10 minutes', 'sever resource availability testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(108, false, 'function1',1,'ping dispatchers ip', 'dispatch connectivity testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(109, false, 'function1',1,'check jump sever health', 'server health testing', 1,2,3,4);
insert into STEP_METADATA_ENTITY ("STEP_CODE", "CORRECTIVE_STEPS", "FUNCTION_TO_EXECUTE", "RESPONSIBLE_PARTY", "STEP_DESCRIPTION", "STEP_TYPE", "VARIABLE01", "VARIABLE02", "VARIABLE03", "VARIABLE04") 
                                           values(110, false, 'function1',1,'check intellimine server health', 'server health testing', 1,2,3,4);


