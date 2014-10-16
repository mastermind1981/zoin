//SkillSet with Gradle and Ant
INSERT INTO `SkillSet` (`id`) VALUES ('1');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '0');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '2');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '3');

//Hero with Gradle and Ant SkillSet
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('1', 'FirstnameTest', 'LastnameTest', 'PrincipalConsultant', '1');

//SkillSet with Ant and Maven
INSERT INTO `SkillSet` (`id`) VALUES ('2');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '3');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '4');

//Mission which needs Ant and Maven SkillSet
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('1', 'TestCo', 'Old Build Specialist', 'PrincipalConsultant', '2');