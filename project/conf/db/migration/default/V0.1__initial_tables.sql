/*
 * @table   role
 * @params  admin / voter
 */
CREATE TABLE IF NOT EXISTS role(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS person (
  id int(11) NOT NULL AUTO_INCREMENT,
  surname varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  iddocument varchar(25) NOT NULL,
  pass varchar(100) NOT NULL,
  country_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (country_id) REFERENCES country(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS committee (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  country_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (country_id) REFERENCES country(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


/*
 * @table   election_type
 * @params  presidential / state
 */
CREATE TABLE IF NOT EXISTS  election_type(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS  election(
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  description varchar(250) NOT NULL,
  assigned_date date NOT NULL,
  electiontype_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (electiontype_id) REFERENCES election_type(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS candidate (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(100) NOT NULL,
  person_id int(11) NOT NULL,
  committee_id int(11) NOT NULL,
  election_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (committee_id) REFERENCES committee(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


/*
 * @table   election_log
 * This table contain the the unanimous vote of every person, needed to
 * validate no duplicate votes
 */
CREATE TABLE IF NOT EXISTS  election_log(
  id int(11) NOT NULL AUTO_INCREMENT,
  person_id int(11) NOT NULL,
  election_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (election_id) REFERENCES election(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


/*
 * @table:  official_participation
 * This table contain the select candidates for elections
 * and his result for elections - id_state will be null
 *
 */
CREATE TABLE IF NOT EXISTS  official_participation(
  id int(11) NOT NULL AUTO_INCREMENT,
  candidate_id int(11) NULL,
  votes int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (candidate_id) REFERENCES candidate(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


