ALTER TABLE  `sc_article` ADD FOREIGN KEY (  `a_owner_id` ) REFERENCES  `scicatalog`.`sc_user` (
`u_id`
) ON DELETE CASCADE ON UPDATE CASCADE ;

ALTER TABLE  `sc_article` ADD FOREIGN KEY (  `a_category_id` ) REFERENCES  `scicatalog`.`sc_category` (
`c_id`
) ON DELETE CASCADE ON UPDATE CASCADE ;