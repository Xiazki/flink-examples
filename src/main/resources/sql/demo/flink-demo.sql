CREATE TABLE datagen (
 f_sequence INT,
 f_random INT,
 f_random_str STRING,
 ts AS localtimestamp,
 WATERMARK FOR ts AS ts
) WITH (
 'connector' = 'datagen',

 -- optional options --

 'rows-per-second'='5',

 'fields.f_sequence.kind'='sequence',
 'fields.f_sequence.start'='1',
 'fields.f_sequence.end'='1000',

 'fields.f_random.min'='1',
 'fields.f_random.max'='1000',

 'fields.f_random_str.length'='10'
)
----split----
CREATE TABLE consoleOutput (
 f_sequence INT,
 f_random INT,
 f_random_str STRING
) WITH (
    'connector' = 'print'
);
----split----
INSERT INTO consoleOutput
SELECT f_sequence,f_random,f_random_str
FROM datagen;