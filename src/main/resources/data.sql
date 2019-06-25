DROP TABLE event IF EXISTS;
CREATE TABLE event (
   id VARCHAR (45),
   type VARCHAR (45),
   host VARCHAR (45),
   event_duration BIGINT,
   alert BOOLEAN DEFAULT FALSE,
   PRIMARY KEY (id)
);