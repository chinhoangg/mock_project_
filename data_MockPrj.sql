-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('1', 'japan');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('2', 'viet nam');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('3', 'lap trinh');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('4', 'manga');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('5', 'trinh tham');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('6', 'van hoc');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('7', 'ngoai ngu');
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('8', 'Toan hoc');users
-- INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`) VALUES ('9', 'khoa hoc');

INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`, `user_id`) VALUES ('1', 'chon sach khoa hoc', '2');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`, `user_id`) VALUES ('2', 'manga', '4');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`, `user_id`) VALUES ('3', 'tim hieu ve lap trinh', '1');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`, `user_id`) VALUES ('4', 'yeu khoa hoc', '5');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book_case` (`id`, `name`, `user_id`) VALUES ('5', 'ngon ngu hay', '3');


INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('1', 'oda', 'one piece', 'truy tim kho bau', '4', 'di tim kho bau cung hai tac', '2001-02-12');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('2', 'admin', 'hoc lap trinh cung FU', 'cong nghe', '3', 'cac ngon ngu lap trinh', '2021-11-05');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('3', 'nguyen du', 'truyen kieu', 'thuy kieu', '6', 'cuoc doi thuy kieu', '1996-10-25');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('4', 'jukiaka', 'sieu nhan gao', 'sieu anh hung', '1', 'cac sieu nhan chong lai quai vat', '2022-11-11');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('5', 'kim dong', 'cuoc song cua loai kien', 'loai kien', '2', 'cuoi doi loai kien', '2006-12-08');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`book` (`id`, `author`, `book_title`, `brief`, `category`, `content`, `published_date`) VALUES ('6', 'peter', 'hoc tieng anh cung toi', 'english', '5', 'hehe', '2001-02-01');

INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`roles` (`role_id`, `role_name`) VALUES ('1', 'admin');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`roles` (`role_id`, `role_name`) VALUES ('2', 'guest');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`roles` (`role_id`, `role_name`) VALUES ('3', 'manage');

INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('1', 'admin@gmail.com', 'ad', '1', 'min', '12345', '0898268981', 'admin');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('2', 'hoang@gmail.com', 'hoang', '1', 'chinh', '12321', '0987654325', 'hoangtc');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('3', 'user@gmail.com', 'user', '0', 'hihi', '1000', '0123456792', 'user12');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('4', 'lam@gmail.com', 'lam', '1', 'bui', '0000', '0192841937', 'lambui');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('5', 'hehe@gmail.com', 'he', '0', 'he', '12345', '0987654321', 'hehe12');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`users` (`id`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `user_name`) VALUES ('6', 'huu@gmail.com', 'huu', '0', 'do', '123', '0192837465', 'huudo');

INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('2', '3');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('3', '2');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('4', '1');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('5', '2');
INSERT INTO `hn22_cpl_fujs_02_book_management_system`.`user_role` (`user_id`, `role_id`) VALUES ('6', '3');

