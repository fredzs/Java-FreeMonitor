drop table testResult;
create table testResult(id int primary key auto_increment, 
                   type varchar(20), 
                   interface varchar(20), 
                   exceptionMsg varchar(40), 
                   lastRunTime timestamp DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP, 
                   state int);
                   