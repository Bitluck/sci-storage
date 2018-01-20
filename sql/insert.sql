INSERT INTO `sc_user`(`u_email`, `u_password`, `u_first_name`, `u_last_name`) VALUES ("asd@asd.asd","pass","first","last");
INSERT INTO `sc_user`(`u_email`, `u_password`, `u_first_name`, `u_last_name`) VALUES ("fgh@fgh.fgh","pass2","first2","last2");

INSERT INTO `sc_category`(`c_name`, `c_description`) VALUES ("category1","small description for category1");
INSERT INTO `sc_category`(`c_name`, `c_description`) VALUES ("category2","small description for category2");

INSERT INTO `sc_article`(`a_title`, `a_authors`, `a_owner_id`, `a_category_id`, `a_path`) VALUES ("title1","author1",1,1,"/path/1.pdf");
INSERT INTO `sc_article`(`a_title`, `a_authors`, `a_owner_id`, `a_category_id`, `a_path`) VALUES ("title2","author1, author2",1,1,"/path/2.pdf");
INSERT INTO `sc_article`(`a_title`, `a_authors`, `a_owner_id`, `a_category_id`, `a_path`) VALUES ("title3","author2",1,2,"/path/3.pdf");
INSERT INTO `sc_article`(`a_title`, `a_authors`, `a_owner_id`, `a_category_id`, `a_path`) VALUES ("title4","author3",2,1,"/path/4.pdf");
INSERT INTO `sc_article`(`a_title`, `a_authors`, `a_owner_id`, `a_category_id`, `a_path`) VALUES ("title5","author1, author3",2,2,"/path/5.pdf");
