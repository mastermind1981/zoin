// Hero Frank
INSERT INTO `SkillSet` (`id`) VALUES ('1');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '0');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '3');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '5');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '6');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1', '7');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('931', 'Frank', 'Beeh', 'PrincipalConsultant', '1');

// Hero Florian
INSERT INTO `SkillSet` (`id`) VALUES ('2');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '0');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '2');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '3');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '6');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('2', '8');
INSERT INTO `Hero` (`id`, `firstName`, `lastName`, `role`, `skillSet_id`) VALUES ('100', 'Florian', 'Besser', 'JuniorSoftwareEngineer', '2');

//Missions
INSERT INTO `SkillSet` (`id`) VALUES ('1001');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '0');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '3');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '6');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '8');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('1', 'Swisscom', 'Junior Java Developer', 'JuniorSoftwareEngineer', '1001');

INSERT INTO `SkillSet` (`id`) VALUES ('1002');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', '0');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', '3');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '5');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '6');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1001', '7');
INSERT INTO `SkillSet_skills` (`SkillSet_id`, `skills`) VALUES ('1002', '8');
INSERT INTO `Mission` (`id`, `companyName`, `name`, `role`, `skillSet_id`) VALUES ('2', 'Swisscom', 'Java Architect', 'LeadSoftwareArchitect', '1002');