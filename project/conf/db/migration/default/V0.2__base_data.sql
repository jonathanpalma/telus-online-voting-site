INSERT INTO role (name) VALUES ('Admin'), ('Voter');

INSERT INTO election_type (name) VALUES ('presidential'), ('state');


INSERT INTO person (surname, name, iddocument, pass, country_id, role_id) VALUES
('Clark Hyde', 'Jeremy Connor', '9997001801', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Wells Hamilton', 'Charlotte Maika', '916700185', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Davenport Sinclair', 'Benjamin Alexander', '9258918815', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Hughes Erikson', 'Jessica Rachel', '9885845888', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Peterson  Pickton', 'Landon Eric', '9785988521', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Harper Khan', 'Henry Jackson', '9129812501', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Morin Campbell', 'Nathaniel Caleb', '9978521801', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Legere Roy', 'Simon Felix', '9267986501', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Palma McKenzie', 'Ryan Gabriel', '9657874801', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 38, 2),
('Palma Flores', 'Jonathan Alexander', '05143948-0', '$2a$10$qddZfj23Ti98yRu5WaBHiutIPuJ6Zpy164ZjrRkK3ollQw7nio7e.', 65, 1);


INSERT INTO committee(name, country_id) VALUES ('omega ruby', 38), ('alpha sapphire', 38), ('delta emerald', 38);


INSERT INTO election(name, description, assigned_date, electiontype_id)
VALUES ('Canada presidential elections', 'Canadian federal elections 2016', '2016/10/30', 1);


INSERT INTO candidate(email, person_id, committee_id, election_id) VALUES ('jeremy.clark.2015@ieee.org', 1, 1, 1);
INSERT INTO candidate(email, person_id, committee_id, election_id) VALUES ('jessihuge@gmail.com', 4, 2, 1);
INSERT INTO candidate(email, person_id, committee_id, election_id) VALUES ('royfelix@hotmail.com', 8, 3, 1);
