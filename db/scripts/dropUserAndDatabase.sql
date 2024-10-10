select pg_terminate_backend(pid) from pg_stat_activity where datname = 'mobile_lines_db';
drop database if exists mobile_lines_db;
drop role if exists testuser;