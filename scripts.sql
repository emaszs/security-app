insert into insecure_user
    select nextval('seq_inc_user_id'), 'petras@gmail.com', 'Petras', 'Petraitis', 'petro', '';
insert into insecure_user 
    select nextval('seq_inc_user_id'), 'jonas@gmail.com', 'Jonas', 'Jonaitis', 'jono', '';
